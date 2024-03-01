package labs.lab4;

/**
 * Digital book item in a library
 */
public class DigitalBook extends Book {
	// ADD YOUR INSTANCE VARIABLES HERE
	int numPages;
	int maxNum;
	/**
	 * Constructor
	 * 
	 * @param title		book title
	 * @param author	book author
	 * @param numPages	number of pages
	 */
	public DigitalBook(String title, String author, int numPages) {
		super(title, author);
		this.numPages = numPages;
	}

	
	public int getNumPages() {
		return numPages;
	}
	
	
	public void setNumPages(int numPages) {
		this.numPages = numPages;
	}
	
	
	/**
	 * If the max number of checkouts for this item has not already been reached,
	 * this method checks this item out and returns the loan period; if no more
	 * check outs are available for this item, returns the String "NOT ALLOWED";
	 * overrides LibraryItem.checkOut()
	 */
	@Override
	public String checkOut() {
		if (maxNum < 3) {
			super.isCheckedout = true;
			maxNum++;
			return "14 days";
		} else {
			return "NOT ALLOWED";
		}
	}
	
	
	/**
	 * Checks in this item  (frees up one checkout for this item); overrides 
	 * LibraryItem.checkIn()
	 */
	@Override
	public void checkIn() {
		// FILL IN
	}
	
	
	/**
	 * Returns true if the parameter object is a DigitalBook that has the same
	 * instance variable value(s) as this one
	 */
	public boolean equals(Object otherObject) {
		if (super.equals(otherObject)) {
			Book other = (Book) otherObject;
			return getAuthor().equals(other.getAuthor());
		}
		return false;
	}
}