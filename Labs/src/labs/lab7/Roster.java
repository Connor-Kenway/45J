package labs.lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class maintains a roster of Persons
 */
public class Roster {
	// ADD YOUR INSTANCE VARIABLES EHRE
	private List<Person> persons;
	/**
	 * Constructs an empty Roster
	 */
	public Roster() {
		this.persons = new ArrayList<>();
	}
	
	
	/**
	 * Adds a Person with the given id and name to the roster
	 * 
	 * @param id
	 * @param name
	 */
	public void addPerson(int id, String name) {
		persons.add(new Person(id, name));
	}
	
	
	/**
	 * if a Person with the given name is found, removes all
	 * Persons with this name from the roster and returns true; if
	 * not found, returns false.
	 * 
	 * @param name	name of person to remove
	 * 
	 * @return	true if person was found, otherwise false
	 */
	public boolean removePerson(String name) {
		int originalSize = persons.size();

		persons.removeIf(person -> person.name.equals(name));

		return persons.size() < originalSize;
	}
	
	
	/**
	 * if a Person with the given id is found, removes all
	 * Persons with this id from the roster and returns true; if
	 * not found, returns false.
	 * 
	 * @param id	id of person to remove
	 * 
	 * @return	true if person was found, otherwise false
	 */
	public boolean removePerson(int id) {
		int originalSize = persons.size();

		persons.removeIf(person -> person.id == id);

		return persons.size() < originalSize;
	}
	
	
	/**
	 * if a Person with the given name is found, returns the
	 * first Person found with this name; if not found, returns null
	 * 
	 * @param name	name of person to find
	 * 
	 * @return	person if found, otherwise null
	 */
	public Person findPerson(String name) {
		for (Person person : persons) {
			if (person.name.equals(name)) {
				return person;
			}
		}
		return null;
	}
	
	
	/**
	 * if a Person with the given id is found, returns the
	 * first Person found with this id; if not found, returns null
	 * 
	 * @param id	id of person to find
	 * 
	 * @return	person if found, otherwise null
	 */
	public Person findPerson(int id) {
		for (Person person : persons) {
			if (person.id == id) {
				return person;
			}
		}
		return null;
	}
	
	
	/**
	 * returns a String containing the names of all Persons in the
	 * roster, in ascending lexicographic order, with a space in
	 * between each name
	 * 
	 * @return
	 */
	public String getNamesInAlphaOrder() {
		List<String> names = new ArrayList<>();
		for (Person person : persons) {
			names.add(person.name);
		}
		Collections.sort(names);
		return String.join(" ", names);
	}
}
