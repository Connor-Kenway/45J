package labs.lab3;

/**
 * A class that shows how restroom stalls are occupied.
 */

public class Restroom {

	// ADD YOUR INSTANCE VARIABLES HERE
	int stallsCount;
	int emptyStall;

	boolean[] stalls;


	/**
	 * Constructs a restroom with a given number of stalls.
	 * 
	 * @param numStalls the number of stalls
	 */
	public Restroom(int numStalls) {
		stallsCount = numStalls;
 		stalls = new boolean[numStalls];

//		for (int i = 0; i < numStalls ; ++i) {
//			totalStalls += "_";
//		}
//		totalStalls += "_";
	}

	/**
	 * Adds an occupant in the middle of the longest sequence of unoccupied stalls.
	 * If there are multiple longest sequences, adds occupant in the first one.
	 * If the middle of the sequence falls between 2 stalls, adds occupant in the 
	 * stall just right of the middle.
	 */
	public void addOccupant() {
		int maxDistance = 0;
		int start = 0;
		int bestPos = 0;

		for (int i = 0; i <= stalls.length; i++) {
			if (i < stalls.length && !stalls[i]) {
				continue;
			}
			int length = i - start;
			if (length > maxDistance) {
				maxDistance = length;
				bestPos = start + length / 2;
			}
			start = i + 1;
		}

		if (bestPos < stalls.length) {
			stalls[bestPos] = true;
		}
	}


	/**
	 * Gets a string describing the current stall occupation
	 * 
	 * @return a string with _ for an empty stall and X for an occupied one
	 */
	public String getStalls() {
		StringBuilder sb = new StringBuilder();
		for (boolean occupied : stalls) {
			sb.append(occupied ? "X " : "_ ");
		}
//		System.out.println(sb.toString().trim());
		return sb.toString().trim();
	}

	public static void main(String[] args) {
		Restroom wc = new Restroom(12);
		wc.addOccupant();
		wc.getStalls(); // returns "_ _ _ _ _ _ X _ _ _ _ _"
		wc.addOccupant();
		wc.getStalls(); // returns "_ _ _ X _ _ X _ _ _ _ _";
		wc.addOccupant();
		wc.getStalls(); // returns "_ _ _ X _ _ X _ _ X _ _";
		wc.addOccupant();
		wc.getStalls(); // returns "_ X _ X _ _ X _ _ X _ _";
		wc.addOccupant();
		wc.getStalls(); // returns "_ X _ X _ X X _ _ X _ _";
		wc.addOccupant();
		wc.getStalls(); // returns "_ X _ X _ X X _ X X _ _";
		wc.addOccupant();
		wc.getStalls(); // returns "_ X _ X _ X X _ X X _ X";
		wc.addOccupant();
		wc.getStalls(); // returns "X X _ X _ X X _ X X _ X";
		wc.addOccupant();
		wc.getStalls(); // returns "X X X X _ X X _ X X _ X";
	}

}
