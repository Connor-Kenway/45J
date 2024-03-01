package labs.lab4;

import java.util.Objects;

/**
 * A magazine item in a library
 */
public class Magazine extends LibraryItem {
	// ADD YOUR INSTANCE VARIABLES HERE
	int issueNumber;
	String publicationDate;
	
	/**
	 * Constructor
	 * 
	 * @param title				magazine title
	 * @param issueNumber		magazine issue number
	 * @param publicationDate	magazine publication date
	 */
	public Magazine(String title, int issueNumber, String publicationDate) {
		super(title);
		this.issueNumber = issueNumber;
		this.publicationDate = publicationDate;
	}
	
	
	public int getIssueNumber() {
		return issueNumber;
	}
	
	
	public void setIssueNumber(int issueNumber) {
		this.issueNumber = issueNumber;
	}

	
	public String getPublicationDate() {
		return publicationDate;
	}

	
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
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
	 * Returns true if the parameter object is a Magazine that has the same instance 
	 * variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		if (this == otherObject) return true;
		if (otherObject == null || getClass() != otherObject.getClass()) return false;
		LibraryItem other = (LibraryItem) otherObject;
		return(Objects.equals(getTitle(), other.getTitle()));
	}
}