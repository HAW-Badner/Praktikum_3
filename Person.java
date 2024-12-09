/* Programm : Person.java
   Autoren  : Sönke Baumgarten, Sven Andris
   Datum    : 09.12.2024
*/

public class Person {

    // attributes
    private String address;
    private String title;
    private String givenName;
    private String surname;

    // constructors
    public Person(String address, String title, String givenName, String surname) {
        this.address = address;
        this.title = title;
        this.givenName = givenName;
        this.surname = surname;
    }

    // methods
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public static void main(String[] args) {
        Person kloebner = new Person("Herr", "Dr.", "Anton", "Klöbner");
        PersonView view = new PersonView(kloebner);
    }
}
