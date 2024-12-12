package Aufgabe5;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
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

/* Programm : Person.java
   Autoren  : Sönke Baumgarten, Sven Andris
   Datum    : 12.12.2024
*/

public class Calculator extends JFrame implements ActionListener {
    // attributes
    private JComboBox<Renter> coBoxRenter;
    private JRadioButton radBFlat;
    private JRadioButton radBSqmeter;
    private JRadioButton radBRenter;
    private JTextField textfCost;
    private JButton okButton;
    private JLabel labelResult;
    private int sumOfRenter = 0;
    private int sumOfFlats = 0;
    private double sumOfSm = 0;
    private double result = 0;
    private Renter[] renterArr;

    DecimalFormat decFormats = new DecimalFormat("#,##0.00$");

    // constructors
    public Calculator(Renter[] renterArr) {

        super("Nebenkosten-Kalkulator");

        this.renterArr = renterArr;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setBackground(Color.LIGHT_GRAY);
        c.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Combo-Box
        coBoxRenter = new JComboBox<Renter>(renterArr);
        c.add(coBoxRenter);

        // Radio-Buttons
        radBFlat = new JRadioButton("pro Wohnung", true);
        radBSqmeter = new JRadioButton("Nach Quadratmetern");
        radBRenter = new JRadioButton("Nach Bewohner/innen");
        ButtonGroup bg = new ButtonGroup();
        bg.add(radBFlat);
        bg.add(radBSqmeter);
        bg.add(radBRenter);
        c.add(radBFlat);
        c.add(radBSqmeter);
        c.add(radBRenter);

        // Textfeld
        textfCost = new JTextField(10);
        c.add(textfCost);

        setSize(300, 400);
        setLocation(100, 100);
        setVisible(true);

        // OK - Button
        okButton = new JButton("OK");
        okButton.addActionListener(this);
        c.add(okButton);

        // Label
        labelResult = new JLabel(decFormats.format(result));
        c.add(labelResult);

        // Berechnung
        sumOfFlats = renterArr.length; // Berechne Anzahl der Wohnungen

        for (Renter r : renterArr) { // Berechne Anzahl der Personen
            sumOfRenter += r.getPersons();
        }

        for (Renter r : renterArr) { // Berechne Anzahl der Quadratmeter
            sumOfSm += r.getSquareMeter();
        }
    }

    // methods
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == okButton) {
                double userInput = Double.parseDouble(textfCost.getText());
                if (radBFlat.isSelected() && sumOfFlats > 0 && userInput > 0) {
                    result = userInput / (double)sumOfFlats;
                    // labelResult.setText(Double.toString(result));
                    labelResult.setText(decFormats.format(result));
                } else if (radBSqmeter.isSelected() && sumOfSm > 0 && userInput > 0) {
                    result = userInput * renterArr[coBoxRenter.getSelectedIndex()].getSquareMeter() / (double)sumOfSm;
                    labelResult.setText(decFormats.format(result));
                } else if (radBRenter.isSelected() && sumOfRenter > 0 && userInput > 0) {
                    result = userInput * renterArr[coBoxRenter.getSelectedIndex()].getPersons() / (double)sumOfRenter;
                    labelResult.setText(decFormats.format(result));
                } else {
                    JOptionPane.showMessageDialog(this, "Daten inkonsistent", "Achtung!", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(this, "Eingegebener Wert ist keine gültige Zahl! Bitte wiederholen.", "DUBEL!!!", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void main(String[] args) {
        Calculator test = new Calculator(Renter.rentersInPasadena);

    }
}
