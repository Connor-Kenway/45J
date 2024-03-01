package labs.lab5;

import java.util.Objects;

/**
 * This class represents a student with a name and ID.
 */
public class Student implements Comparable {

	// ADD YOUR INSTANCE VARIABLES HERE
	String name;
	int id;
	/**
	 * Constructs a student object
	 * 
	 * @param name the student's name
	 * @param id   the student's id
	 */
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}


	/**
	 * Gets the student's name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * Gets the student's id
	 * 
	 * @return the name
	 */
	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return name + ", " + id;
	}


	@Override
	public boolean equals(Object otherObject) {
		Student temp = (Student) otherObject;
		return this.name.compareTo(temp.name) == 0 && this.id == temp.id;
	}


	/**
	 * Compares student objects first by name, then by id
	 * 
	 * @param other Other student against which to compare
	 * @return negative int if this students comes before, 0 if equal, positive int
	 *         if this student comes after
	 */
	public int compareTo(Object other) {
		Student temp = (Student) other;
		int nameComparison = this.name.compareTo(temp.name);
		if (nameComparison != 0) {
			return nameComparison;
		}
		return Integer.compare(this.id, temp.id);
	}

	public static void main(String[] args) {
		Student[] students = new Student[] {
				new Student("Robert", 1234), new Student("Emily", 4321),
				new Student("Harry", 1111), new Student("Kelly", 18),
				new Student("Mike", 18), new Student("Mike", 18),
				new Student("Robert", 50000), new Student("Emily", 9832),
				new Student("Emily", 19), new Student("ROBERT", 7778) };

	}
}
