package labs.lab5;

import static org.junit.Assert.assertEquals;

/**
 * Test class for Comparable Student objects.
 */
public class StudentFinder {

	/**
	 * Determines first student in a non-empty array of Student objects.
	 * 
	 * @param students array of Student objects
	 * @return first Student
	 */
	public static Student firstStudent(Student[] students) {
		Student firstStudent = students[0];
		for (int i = 1; i < students.length; i++) {
			if (students[i].compareTo(firstStudent) < 0) {
				firstStudent = students[i];
			}
		}
		return firstStudent;
	}


	/**
	 * Determines last student in a non-empty array of Student objects.
	 * 
	 * @param students array of Student objects
	 * @return last Student
	 */
	public static Student lastStudent(Student[] students) {
		Student lastStudent = students[0];
		for (int i = 1; i < students.length; ++i) {
			if (students[i].compareTo(lastStudent) > 0) {
				lastStudent = students[i];
			}
		}
		return lastStudent;
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
