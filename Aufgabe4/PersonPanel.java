package Aufgabe4;

/* Programm : PersonPanel.java
   Autoren  : Sönke Baumgarten, Sven Andris
   Datum    : 12.12.2024
*/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PersonPanel extends JPanel {
    // attributes
    private Person personToShow; // Attribut für erstellte Person

    // constructor
    public PersonPanel(Person personToShow) {
        this.personToShow = personToShow; // Speichere Daten der erstellten Person
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(600, 300));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);                        // Never forget!
        Dimension d = getSize();
        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.setColor(Color.BLACK);
        g.drawString(personToShow.getAddress() +        // Schreibe Attribute in der Höhe mittig auf Panel
                    " " + personToShow.getTitle() +
                    " " + personToShow.getGivenName() + 
                    " " + personToShow.getSurname(),10, d.height / 2); 
    }
}
