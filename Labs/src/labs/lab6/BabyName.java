package labs.lab6;

/**
 * A name in a list of baby names
 */
public class BabyName {

	// ADD YOUR INSTANCE VARIABLES HERE
	String name;
	int rank;
	int count;
	double percent;
	/**
	 * Constructor
	 * 
	 * @param name    the name
	 * @param rank    rank compared to other names
	 * @param count   how many babies with this name born
	 * @param percent percent of babies with this name born
	 */
	public BabyName(String name, int rank, int count, double percent) {
		this.name = name;
		this.rank = rank;
		this.count = count;
		this.percent = percent;
	}


	public String getName() {
		return name;
	}


	public int getRank() {
		return rank;
	}


	public int getCount() {
		return count;
	}


	public double getPercent() {
		return percent;
	}

}