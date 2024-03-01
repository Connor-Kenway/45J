package labs.lab1;

import java.awt.Rectangle;
import java.math.BigDecimal;
import java.util.Random;

public class Main {

	/**
	 * Given a string of even length, returns a string made of the middle 
	 * two chars, so the string "string" yields "ri". The string length 
	 * will be at least 2 and an even length.
	 * 
	 * @param str	the input string
	 * 
	 * @return	a string made of the middle two chars
	 */
	public static String problem1_middle(String str) {
		int mid  = str.length()/2;
		return str.substring(mid-1,mid+1);
	}
	
	
	/**
	 * Given a string, if one or both of the last 2 chars is 'x' 
	 * (case-sensitive), return the string without those 'x' chars, 
	 * otherwise return the string unchanged. The string can be any 
	 * length, including 0.
	 * 
	 * @param str	the input string
	 * 
	 * @return	if one or both of the last 2 chars is 'x' 
	 * (case-sensitive), the string without those 'x' chars, otherwise
	 * the string unchanged.
	 */
	public static String problem2_removeChars(String str) {
		int length = str.length();

		if (str.isEmpty() || str.length() == 1) {
			if (str.equals("x")) {
				return "";
			} else {
				return str;
			}
		}

		if (str.substring(length - 2).equals("xx")){ // check if both last two char are x
			return str.substring(0, length-2);
		}
		if (str.charAt(length - 2) == 'x') { // check if second to last char is x
			return str.substring(0, length - 2) + str.substring(length-1);
		}
		if (str.charAt(length - 1) == 'x') { // check if last char is x
			return str.substring(0, length - 1);
		}
			return str;
	}
	
	
	/**
	 * A method for a student who is taking a multiple-choice test and has not studied,
	 * so wants to choose all of their answers randomly. The method will take as
	 * parameters the number of possible choices for each question and return 10
	 * answers as a string, with each answer separated by a space.
	 * 
	 * @param numChoices	number of possible choices for each question
	 * 
	 * @return	10 answers as a string, with each answer separated by a space
	 */
	public static String problem3_chooseAnswers(int numChoices) {
		Random random = new Random();
		String answers = "";
		for (int i = 1; i < 10; i++) {
			answers = answers + (1 + random.nextInt(numChoices) ) + " ";
		}
		answers = answers + (1 + random.nextInt(numChoices));
		return answers;
	}
	
	
	/**
	 * Given a Rectangle object that is a square (has 4 equal sides), applies the
	 * Rectangle.translate and Rectangle.grow methods to modify the square so
	 * that:
	 * 
	 * 1) its sides are each 10 units longer than the original, and
	 * 2) it has the same top-left corner as the original.
	 * 
	 * Returns the new Rectangle (square).
	 * 
	 * @param r	the input Rectangle
	 * 
	 * @return	the Rectangle with its sides each 10 units longer than the original
	 * and with the same top-left corner as the original
	 */
	public static Rectangle problem4_growSquare(Rectangle r) {
		r.translate(5, 5);
		r.grow(5, 5);
		return r.getBounds();
	}
	
	
	/**
	 * The BigDecimal class represents decimal numbers with an arbitrary number of digits (the
	 * double and float types cannot express very high precision). Given a BigDecimal object
	 * and an integer, calculate a BigDecimal that is equal to the original BigDecimal raised to 
	 * the power of the given integer. Then negate that number and return the result.
	 * 
	 * See the BigDecimal class in the Java API docs.
	 * 
	 * @param big	the original BigDecimal
	 * @param power	the power to which to raise big
	 * 
	 * @return		big raised to the power of power, then negated
	 */
	public static BigDecimal problem5_bigPowerNegate(BigDecimal big, int power) {
		return big.pow(power).negate(); // FIX ME
	}

	public static void main(String[] args) {
		System.out.println(problem5_bigPowerNegate(new BigDecimal(3.1), 2));
		System.out.println(problem5_bigPowerNegate(new BigDecimal(-0.1993), 3));

	}
}
