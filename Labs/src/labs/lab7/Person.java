package labs.lab7;

/**
 * A person.
 */
public class Person implements Comparable {
	// ADD YOUR INSTANCE VARIABLES HERE
	int id;
	String name;

	/**
	 * Construct a Person object.
	 * 
	 * @param aName the name of the person
	 */
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * Compares Person objects by name
	 */
	@Override
	public int compareTo(Object otherObject) {
		Person otherPerson = (Person) otherObject;
		return this.name.compareTo(otherPerson.name);
	}

	/**
	 * Gets the name of the person.
	 * 
	 * @return the name of the person
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the id of the person
	 * 
	 * @return	the id of the person
	 */
	public int getId() {
		return id;
	}
}
