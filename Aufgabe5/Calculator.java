package Aufgabe5;

/* Programm : Calculator.java
   Autoren  : Sönke Baumgarten, Sven Andris
   Datum    : 12.12.2024
*/

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Calculator extends JFrame implements ActionListener {
    // attributes
    private JComboBox<Renter> coBoxRenter;
    private JRadioButton radBFlat;
    private JRadioButton radBSqmeter;
    private JRadioButton radBRenter;
    private JTextField textfCost;
    private JButton okButton;
    private JLabel labelResult;

    private int sumOfRenter = 0;        // Attribut zur Berechnung der Summe aller Mieter.
    private int sumOfFlats = 0;         // Attribut zur Berechung der Summe aller Wohnungen.
    private double sumOfSm = 0;         // Attribut zur Berechung der Summe der Gesamt-Quadratmeter.
    private double result = 0;          // Attribut für den berechneten Betrag.
    private Renter[] renterArr;         

    private static final DecimalFormat decFormats = new DecimalFormat("#,##0.00$");  // Erstellung des Formats für 2 Nachkommastellen.

    // constructors
    public Calculator(Renter[] renterArr) {
        super("Nebenkosten-Kalkulator");

        this.renterArr = renterArr;     // Speichere Daten aus der Klasse Renter                 

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new GridLayout(7,2,10,10));     // Wende Grid-Layout mit 7 Zeilen / 2 Spalten an

        // Combo-Box
        c.add(new JLabel("Mieter: "));              // Label für die Mieterauswahl.    
        coBoxRenter = new JComboBox<Renter>(renterArr);  // Übergebe ComboBox daten aus renterArr. toString() wird automatisch angewendet.   
        c.add(coBoxRenter);                              // Füge zum Frame hinzu.

        // Radio-Buttons
        c.add(new JLabel("Verechnung: "));                           // Label für Radiobuttons
        radBFlat = new JRadioButton("pro Wohnung", true);   // Erstelle Radiobuttons
        radBSqmeter = new JRadioButton("Nach Quadratmetern");
        radBRenter = new JRadioButton("Nach Bewohner/innen");
        ButtonGroup bg = new ButtonGroup();                               // Gruppiere Radiobuttons   
        bg.add(radBFlat);
        bg.add(radBSqmeter);
        bg.add(radBRenter);
        c.add(radBFlat);                 // Füge Radiobuttons Frame hinzu.                           
        c.add(new JLabel(""));      // Platzhalterlabel für Gridlayout.
        c.add(radBSqmeter);
        c.add(new JLabel(""));
        c.add(radBRenter);

        // Textfeld
        c.add(new JLabel("Betrag: "));          // Label für Textfeld.
        textfCost = new JTextField(10);      // Erstelle Textfeld zur Eingabe des Betrags.  
        c.add(textfCost);                            // Füge zu Frame hinzu.

        // OK - Button
        c.add(new JLabel(""));          // Platzhalterlabel für Gridlayout.
        okButton = new JButton("OK");   // Erstelle Button zur Eingabebestätigung.
        okButton.addActionListener(this);    // Subscribe to ok-Button.
        c.add(okButton);                     // Füge Frame hinzu.

        // Label
        c.add(new JLabel("Zu zahlender Betrag: "));         // Formatiertes Label zur Ergebnisausgabe.
        labelResult = new JLabel(decFormats.format(result));     // Auch hier formatierte Ausgabe, dass Startwert korrekt formatiert.
        c.add(labelResult);

        setSize(400, 400);      
        setLocation(100, 100);
        setVisible(true);               // Gehört ganz ans Ende der Frame-Erstellung!

        // Berechnung
        sumOfFlats = renterArr.length;          // Berechne Anzahl der Wohnungen

        for (Renter r : renterArr) {            // Berechne Anzahl der Personen
            sumOfRenter += r.getPersons();
        }

        for (Renter r : renterArr) {            // Berechne Anzahl der Quadratmeter
            sumOfSm += r.getSquareMeter();
        }
    }

    // methods
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {            // Erst Abfragen, ob man von okButton kommt, dann den try...
            try {
                double userInput = Double.parseDouble(textfCost.getText());         // Wandle Benutzereingabe in Typ double um.

                // Pro Wohnung
                if (radBFlat.isSelected() && sumOfFlats > 0 && userInput > 0) {     // Prüfe, welcher Radiobutton ausgewählt, ob nicht /0 und ob Benutzereingabe positiv.
                    result = userInput / (double)sumOfFlats;                        // Berechne Ergebnis.
                    labelResult.setText(decFormats.format(result));                 // Formatiertes Ergebnis in Label schreiben.

                // Nach Quadratmetern
                } else if (radBSqmeter.isSelected() && sumOfSm > 0 && userInput > 0) {
                    result = userInput * renterArr[coBoxRenter.getSelectedIndex()].getSquareMeter() / (double)sumOfSm;
                    labelResult.setText(decFormats.format(result));

                // Nach Bewohner/innen
                } else if (radBRenter.isSelected() && sumOfRenter > 0 && userInput > 0) {
                    result = userInput * renterArr[coBoxRenter.getSelectedIndex()].getPersons() / (double)sumOfRenter;
                    labelResult.setText(decFormats.format(result));
                
                // Ungültige Eingabe oder Daten aus Renter.class nicht passend.
                } else {
                    JOptionPane.showMessageDialog(this, "Daten inkonsistent", "Achtung!", JOptionPane.WARNING_MESSAGE);
                }
            
        } catch (NumberFormatException n) {     // Fange exception ab, wenn Usereingabe keine gültige Zahl ist.
            JOptionPane.showMessageDialog(this, "Eingegebener Wert ist keine gültige Zahl! Bitte wiederholen.", "DUBEL!!!", JOptionPane.ERROR_MESSAGE);
        }
    }
    }

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        Calculator test = new Calculator(Renter.rentersInPasadena);
    }
}
