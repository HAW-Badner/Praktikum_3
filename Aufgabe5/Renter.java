package Aufgabe5;

/**
 * This class models renters of flats in a building. 
 * 
 * @author DRK
 */

public class Renter {
	
	private String name;     // name of the renter 
	private int squareMeter; // size of flat in m^2
	private int persons;     // how many persons live in the flat
	

	/**
	 * Constructor getting all defined values.
	 * @param name
	 * @param squareMeter
	 * @param persons
	 */
	public Renter(String name, int squareMeter, int persons) {
		super();
		this.name = name;
		this.squareMeter = squareMeter;
		this.persons = persons;
	}

	// the usual getters
	public String getName() {
		return name;
	}

	public int getSquareMeter() {
		return squareMeter;
	}
	
	public int getPersons() {
		return persons;
	}

	
	/**
	 * Just print the name of the renter. Everything else is
	 * a matter of Datenschutz :-)
	 */
	@Override
	public String toString() {
		return name;
	}
	
	/**
	 * Definition of a very special building in Pasadena with
	 * a sets of renters that is not really a correct model of
	 * the "Big Bang Theory", but who cares?
	 */
	public static final Renter[] rentersInPasadena 
		= { 
				new Renter("Penny",50,1), // no surname known!
				new Renter("Dr. Dr. Sheldon Cooper",75,2),
				new Renter("Howard Wolowitz",65,2),
				new Renter("Dr. Rajesh Koothrappali",45,1)
		};
	
}