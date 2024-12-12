package Aufgabe4;

 /* Programm : PersonView.java
    Autoren  : Sönke Baumgarten, Sven Andris
    Datum    : 12.12.2024
 */


import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PersonCtrl extends JFrame implements ActionListener{
    // attributes
    private Person personToShow;
    private JRadioButton radButtonMr;
    private JRadioButton radButtonMs;
    private JRadioButton radButtonNone;
    private JComboBox<String> coBoxTitle;
    private static final String[] titles = {"kein", "Dr.", "Prof.Dr."};
    private JTextField givenName;
    private JTextField surname;
    private JButton okButton;

    // constructors
    public PersonCtrl(Person personToShow){
        super("Personen-Controller");             // Füge Titel für das Fenster ein

        this.personToShow = personToShow;

        setDefaultCloseOperation(EXIT_ON_CLOSE);        // Schließe fenster mit X
        Container c = getContentPane();
        c.setBackground(Color.GRAY);
        c.setLayout(new GridLayout(7, 1, 10, 10));  // TESTEN
        
        
        // Radiobuttons fuer die Anrede
        radButtonMr = new JRadioButton("Herr");                     // Radio Buttons erstellen
        radButtonMs = new JRadioButton("Frau", true);
        radButtonNone = new JRadioButton("keine");

        ButtonGroup bgAdr = new ButtonGroup();          // Erstellen einer Buttongroup für die Radiobutton
        bgAdr.add(radButtonMr);                         // Hinzufügen der einzelnen Radiobuttons zur Buttongroup
        bgAdr.add(radButtonMs);
        bgAdr.add(radButtonNone);

        c.add(radButtonMr);             // Radiobuttons auf die Contentpane hinzufuegen
        c.add(radButtonMs);
        c.add(radButtonNone);


        // Combobox fuer die Titel der Person
        coBoxTitle = new JComboBox<String>(titles);         // neue Combobox erstellen
        c.add(coBoxTitle);                                  // zur ContentPane hinzufuegen


        // Textfelder für Vor - und Nachnamen
        givenName = new JTextField("Vorname", 20);
        surname = new JTextField("Nachname", 20);
        c.add(givenName);
        c.add(surname);


        // OK - Button
        okButton = new JButton("OK");
        okButton.addActionListener(this);
        c.add(okButton);

        setSize(300, 400);
        setLocation(100, 100);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton){
            // Anrede
            if (radButtonMr.isSelected()){
                personToShow.setAddress("Herr");
            }
            else if (radButtonMs.isSelected()){
                personToShow.setAddress("Frau");
            }
            else if (radButtonNone.isSelected()){
                personToShow.setAddress("");
            }
            else {
                personToShow.setAddress("Frau");                // kann nicht auftreten, aber im Zweifel lieber "Frau"
            }

            // Titel
            if (coBoxTitle.getSelectedIndex() == 0){                    // Index 0 = kein Titel
                personToShow.setTitle("");
            }
            else if (coBoxTitle.getSelectedIndex() == 1){               // Index 1 = Dr.
                personToShow.setTitle("Dr.");
            }
            else if (coBoxTitle.getSelectedIndex() == 2){               // Index 2 = ProfDr.
                personToShow.setTitle("Prof.Dr.");
            }

            // Namen
            personToShow.setGivenName(givenName.getText());         // Vorname
            personToShow.setSurname(surname.getText());             // Nachname
        }
    }
}
