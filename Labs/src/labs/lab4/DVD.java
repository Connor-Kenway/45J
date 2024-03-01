package labs.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A DVD item in a library
 */
public class DVD extends LibraryItem {
	// ADD YOUR INSTANCE VARIABLES HERE
	List<String> actors;
	
	/**
	 * Constructor
	 * 
	 * @param title		title of the DVD
	 * @param actors	actors in the DVD
	 */
	public DVD(String title, List<String> actors) {
		super(title);
		this.actors = actors;
	}

	
	public List<String> getActors() {
		return actors;
	}
	
	
	public void setActors(List<String> actors) {
		this.actors = actors;
	}
	
	
	/**
	 * If this item is not already checked out, this method checks this item out and 
	 * returns the loan period; if it is already checked out, returns the String 
	 * "NOT ALLOWED"; overrides LibraryItem.checkOut()
	 */
	@Override
	public String checkOut() {
		if (!super.isCheckedout) {
			super.isCheckedout = true;
			return "7 days";
		} else {
			return "NOT ALLOWED";
		}
	}
	
	
	/**
	 * Returns true if the parameter object is a DVD that has the same instance 
	 * variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		if (this == otherObject) return true;
		if (otherObject == null || getClass() != otherObject.getClass()) return false;
		LibraryItem other = (LibraryItem) otherObject;
		return(Objects.equals(getTitle(), other.getTitle()));
	}

	public static void main(String[] args) {
		List<String> actors = new ArrayList<String>();
		actors.add("Amy Adams");
		actors.add("Glenn Close");
		actors.add("Haley Bennett");
		actors.add("Gabriel Basso");
		DVD dv1 = new DVD("whatever this", actors);
		System.out.println(dv1.getActors());
	}
}