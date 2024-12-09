import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PersonPanel extends JPanel {
    //attributes
    private String address;
    private String title;
    private String givenName;
    private String surname;

    //constructor
    public PersonPanel (Person personToShow){
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(600, 300));
        this.address = personToShow.getAddress();                       // Speichere Atrribute der Person
        this.title = personToShow.getTitle();
        this.givenName = personToShow.getGivenName();
        this.surname = personToShow.getSurname();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);                                        // Never forget!
        Dimension d = getSize();
        g.setFont(new Font("Arial",Font.BOLD, 40));
        g.setColor(Color.BLACK);
        g.drawString(address + " " + title + " " + givenName + " " + surname, 10,d.height/2); // Schreibe Attribute in der Höhe mittig auf Panel
    }
}
