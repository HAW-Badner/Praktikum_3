 /* Programm : PersonView.java
    Autoren  : Sönke Baumgarten, Sven Andris
    Datum    : 09.12.2024
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class PersonView extends JFrame {

    //constructors
    public PersonView(Person personToShow){
        super("Personen-Daten");                              // Frame-Titel

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             // Progammende bei x
        Container c = getContentPane();
        c.setBackground(Color.GRAY);                                // Frame-Hintergrund = Grau                             
        c.setLayout(new BorderLayout());                            // Layout des Frames als Borderlayout

        c.add(new PersonPanel(personToShow),BorderLayout.WEST);     // Füge neues JPanel zu Frame hinzu an Position West
        setSize(800,500);
        setLocation(500,200);
        setVisible(true);                                         // Showtime!
    }
}
