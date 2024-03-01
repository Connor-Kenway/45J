package labs.lab6;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * A coin with a monetary value.
 */
public class Coin {

	// ADD YOUR INSTANCE VARIABLES HERE
	double aValue;
	String aName;

	public static final Coin NICKEL = new Coin(.05, "nickel");
	public static final Coin DIME = new Coin(.10, "dime");
	public static final Coin QUARTER = new Coin(.25, "quarter");
	public static final Coin DOLLAR = new Coin(1.0, "dollar");

	private static final DecimalFormat df = new DecimalFormat("0.00");


	/**
	 * Constructs a coin.
	 * 
	 * @param aValue the monetary value of the coin.
	 * @param aName  the name of the coin
	 */
	public Coin(double aValue, String aName) {
		this.aValue = aValue;
		this.aName = aName;
	}


	/**
	 * Gets the coin value.
	 * 
	 * @return the value
	 */
	public double getValue() {
		return aValue;
	}


	/**
	 * Gets the coin name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return aName;
	}


	/**
	 * Returns a string representation of the coin consisting of the name, " @ $", 
	 * and the value, formatted with 2 decimal places after the decimal point
	 */
	@Override
	public String toString() {
		double roundOff = (double) Math.round(aValue * 100) /100;
		return aName + " @ $" + roundOff;
	}

	public static void main(String[] args) {
		Coin quime = new Coin(0.175, "quime");
		System.out.println(quime.toString());
	}
}
