package labs.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * An abstract item that can be checked out of a library
 */
public abstract class LibraryItem {
	// ADD YOUR INSTANCE VARIABLES HERE
	String title;
	boolean isCheckedout;
	
	/**
	 * Constructor
	 * 
	 * @param title	title of the item
	 */
	public LibraryItem(String title) {
		this.title = title;
	}
	
	
	public String getTitle() {
		return title;
	}
	
	
	public boolean isCheckedOut() {
		return isCheckedout;
	}
	
	
	public void setCheckedOut(boolean checkedOut) {
		isCheckedout = checkedOut;
	}
	
	
	/**
	 * Causes this item to be checked out
	 * 
	 * @return	a message about the check out
	 */
	public abstract String checkOut();
	
	
	/**
	 * Causes this item to be checked in
	 */
	public void checkIn() {
		isCheckedout = false;
	}
	
	
	public String toString() {
		return title;
	}
	
	
	/**
	 * Returns true if the parameter object is a LibraryItem that has the same instance
	 * variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		if (this == otherObject) return true;
		if (otherObject == null || getClass() != otherObject.getClass()) return false;
		LibraryItem other = (LibraryItem) otherObject;
		return(Objects.equals(getTitle(), other.getTitle()));
	}

	public static void main(String[] args) {
	}
}