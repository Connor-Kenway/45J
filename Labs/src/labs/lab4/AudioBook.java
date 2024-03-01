package labs.lab4;

/**
 * An audio book item in a library
 */
public class AudioBook extends Book {
	// ADD YOUR INSTANCE VARIABLES HERE
	double playingTime;
	int maxNum;

	/**
	 * Constructor
	 * 
	 * @param title			audio book title
	 * @param author		audio book author
	 * @param playingTime	audio book playing time
	 */
	public AudioBook(String title, String author, double playingTime) {
		super(title, author);
		this.playingTime = playingTime;
	}

	
	public double getPlayingTime() {
		return playingTime;
	}
	
	
	public void setPlayingTime(double playingTime) {
		this.playingTime = playingTime;
	}
	
	
	/**
	 * If the max number of checkouts for this item has not already been reached,
	 * this method checks this item out and returns the loan period; if no more
	 * check outs are available for this item, returns the String "NOT ALLOWED";
	 * overrides LibraryItem.checkOut()
	 */
	@Override
	public String checkOut() {
		if (maxNum < 2) {
			super.isCheckedout = true;
			maxNum++;
			return "28 days";
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
		if (maxNum < 0) {
			System.out.println("NO MORE BOOK");
		} else {
			maxNum--;
		}
	}
	
	
	/**
	 * Returns true if the parameter object is an AudioBook that has the same
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