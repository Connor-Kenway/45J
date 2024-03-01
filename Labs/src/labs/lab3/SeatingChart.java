package labs.lab3;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 * A theater seating chart implemented as a 2-d array of ticket prices
 */
public class SeatingChart {
	// ADD YOUR INSTANCE VARIABLES HERE
	int[][] sittingChart = {
			{40, 50, 50, 50, 40},
			{30, 40, 40, 40, 30},
			{20, 30, 30, 30, 20},
			{10, 20, 20, 20, 10},
			{10, 10, 10, 10, 10}
	};

	String stringChart = "";

	/**
	 * Returns a string that represents the price of seats in a grid-like pattern.
	 */
	public String getSeatingChart() {
		stringChart = "";
		for (int i = 0; i < 5 ; ++i) {
			for (int j = 0; j < 4; ++j) {
				int seat = sittingChart[i][j];
				if (seat == 0) {
					stringChart += " ";
				}
				stringChart += seat + " ";
			}
			if (sittingChart[i][4] == 0) {
				stringChart += " ";
			}
			stringChart += sittingChart[i][4];
			stringChart += "\n";
		}
		return stringChart;
	}

	
	/**
	 * Goes from left to right and front to back to find a seat with the specified
	 * price, then, if found, sets its price to 0 to mark it as sold. If no seat 
	 * is found with the specified price, the seating chart remains unchanged. 
	 * Assume all inputs are valid ints.
	 * 
	 * @param price the price to mark to zero
	 */
	public void sellSeatByPrice(int price) {
		for (int i = 0; i < 5 ; ++i) {
			for (int j = 0; j < 5; ++j) {
				if (sittingChart[i][j] == price) {
					sittingChart[i][j] = 0;
					return;
				}
			}
		}
	}

	
	/**
	 * Marks the specified seat as sold by setting its price to 0. If the seat 
	 * doesn't exist, the seating chart remains unchanged. Valid rows are A through 
	 * E, case sensitive (A is the front row, E is the back row). Valid seats are 1 
	 * through 5 (if facing the front/stage, 1 is the leftmost seat, 5 is the 
	 * rightmost seat). Assume all inputs are valid chars and ints.
	 */
	public void sellSeatByNumber(char row, int seat) {
		Dictionary<Character, Integer> dict= new Hashtable<>();
		dict.put('A', 0);
		dict.put('B', 1);
		dict.put('C', 2);
		dict.put('D', 3);
		dict.put('E', 4);

		for (int i = 0; i < 5 ; ++i) {
			for (int j = 0; j < 5; ++j) {
				if (dict.get(row) == null) {
					continue;
				}
				if (i == dict.get(row) && j == seat-1) {
					sittingChart[i][j] = 0;
					return;
				}
			}
		}
	}

	public static void main(String[] args) {
		SeatingChart chart = new SeatingChart();
		System.out.println(chart.getSeatingChart());
		chart.sellSeatByNumber('D', 5);
		chart.sellSeatByNumber('B', 2);
		chart.sellSeatByNumber('b', 3);
		chart.sellSeatByPrice(10);
		chart.sellSeatByPrice(10);
		chart.sellSeatByPrice(30);
		System.out.println(chart.getSeatingChart());

	}
}
