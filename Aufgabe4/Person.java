package Aufgabe4;

/* Programm : Person.java
   Autoren  : Sönke Baumgarten, Sven Andris
   Datum    : 12.12.2024
*/

public class Person {

    // attributes
    private String address;
    private String title;
    private String givenName;
    private String surname;
    private PersonView myView;

    // constructors
    public Person(String address, String title, String givenName, String surname) {
        this.address = address;
        this.title = title;
        this.givenName = givenName;
        this.surname = surname;
        this.myView = null;
    }

    // methods
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        if (myView != null){
            myView.repaint();
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        if (myView != null)
            myView.repaint();
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
        if (myView != null)
            myView.repaint();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
        if (myView != null)
            myView.repaint();
    }

    public PersonView getMyView() {
        return myView;
    }

    public void setMyView(PersonView myView) {
        this.myView = myView;
    }

    public static void main(String[] args) {
        Person kloebner = new Person("Frau", "Dr.", "Anton", "Klöbner");
        PersonView view = new PersonView(kloebner);
        kloebner.setMyView(view); 
        PersonCtrl ctrl = new PersonCtrl(kloebner);
    }


}
