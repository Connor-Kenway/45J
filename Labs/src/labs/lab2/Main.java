package labs.lab2;

import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

	/**
	 * A shop wants to reward its best customers with a discount based on the 
	 * customer's number of items bought (first parameter) and the number of new 
	 * customers referred by the customer (second parameter). The discount is in
	 * percents and is equal to the sum of the number of items purchased and the
	 * referrals, but it cannot exceed 75 percent. 
	 * 
	 * @param numItemsBought	number of items bought
	 * @param numClientsReferred	number of clients referred
	 * 
	 * @return	discount, in percents
	 */
	public static int problem1_getDiscount(int numItemsBought, int numClientsReferred) {
		int discount;
		discount = (numItemsBought + numClientsReferred);
        return Math.min(discount, 75);
    }
	
	
	/**
	 * Reads a number between 1,000 and 999,999 from the user and prints it with a 
	 * comma separating the thousands.
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem2_printWithCommas(new Scanner(System.in));
	 */
	public static void problem2_printWithCommas(Scanner in) {
		System.out.print("Please enter an integer between 1000 and 999999: " );
		int number = in.nextInt();
		DecimalFormat formatter = new DecimalFormat("#,###");
		String formattedNumber = formatter.format(number);
		System.out.print(formattedNumber);
	}
	
	
	/**
	 * Accepts an int as a parameter and returns a String that contains the 
	 * sequence of individual digits, each separated by one space. You may assume 
	 * that the input always has exactly five digits and is not negative.
	 * 
	 * @param number	the input number
	 * 
	 * @return	a String that contains the sequence of individual digits, each 
	 * separated by one space
	 */
	public static String problem3_printDigits(int number) {
		StringBuilder seq = new StringBuilder();
		String str_number = String.valueOf(number);

		for (int i = 0; i < 4; ++i){
			seq.append(str_number.charAt(i)).append(" ");
		}
		seq.append(str_number.charAt(4));

		return seq.toString();

//		String seq = "";
//		String number_str = String.valueOf(number);
//		int length = number_str.length();
//		for (int i = 0; i < length-1 ;++i){
//			seq = seq + number_str.charAt(i) + " ";
//		}
//		seq = seq + number_str.charAt(length-1);
//		return seq;
	}
	
	
	/**
	 * Computes the total of a sticker order based on the price per sticker and number
	 * of stickers, which are prompted for from the user
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problemr_compoundInterest(new Scanner(System.in));
	 */
	public static void problem5_compoundInterest(Scanner in) {
		System.out.print("Enter principal amount: " );
		double principle = in.nextDouble();
		System.out.print("Enter the annual rate of interest: " );
		double annual = in.nextDouble();
		System.out.print("Enter the number of years the amount is invested: ");
		int years = in.nextInt();
		System.out.print("Enter the number of times the interest is compounded per year: ");
		int compound_rate = in.nextInt();
		double result = principle * Math.pow((1 + (annual/100/compound_rate)), years*compound_rate);
		System.out.print('$');
		System.out.printf("%.2f", principle);
		System.out.print(" invested at ");
		System.out.print(annual);
		System.out.print("% for " + years + " years compounded " + compound_rate + " times annually is $");
		System.out.printf("%.2f", result);
		System.out.print('.');
	}
	
	/**
	 * Given three integers a, b, and c, one of them is small, one is medium, and
	 * one is large. Return true if the three values are evenly spaced, so the
	 * difference between small and medium is the same as the difference between
	 * medium and large.
	 * 
	 * @param a first integer
	 * @param b second integer
	 * @param c third integer
	 * 
	 * @return true if the three values are evenly space, false otherwise
	 */
	public static boolean problem6_evenlySpaced(int a, int b, int c) {
		int s, m ,l;
		if (a > b && a > c) {
			l = a;
			if (b < c) {
				s = b;
				m = c;
			} else {
				s = c;
				m = b;
			}
		} else if (b > a && b > c) {
			l = b;
			if (a < c) {
				s = a;
				m = c;
			} else {
				s = c;
				m = a;
			}
		} else {
			l = c;
			if (b < a) {
				s = b;
				m = a;
			} else {
				s = a;
				m = b;
			}
		}
		return Math.abs(s-m) == Math.abs(l-m);
	}
	
	
	/**
	 * 
	 * @param a first number
	 * @param b second number
	 * @param c third number
	 * @return true if one of b or c is "close" (differing from a by at most 1),
	 *         while the other is "far", differing from both other values by 2 or
	 *         more.
	 */
	public static boolean problem7_nearAndFar(int a, int b, int c) {
		if (Math.abs(b - a) <= 1 && Math.abs(c - a) >= 2 && Math.abs(c - b) >= 2) {
			return true;
		} else {
			return Math.abs(c - a) <= 1 && Math.abs(b - a) >= 2 && Math.abs(b - c) >= 2;
		}
	}
	
	
	/**
	 * 
	 * @param dashboardLeft
	 * @param dashboardRight
	 * @param childLock
	 * @param masterUnlock
	 * @param insideLeftLatch
	 * @param outsideLeftLatch
	 * @param insideRightLatch
	 * @param outsideRightLatch
	 * @param gearshift
	 * 
	 * @return "Left door opens", "Right door opens", "Both doors open",
	 * or "No door opens" as appropriate
	 *
	 * A minivan has two sliding doors. Each door can be opened by either
	 * a dashboard switch (L, R) , its inside handle (L, R), or its outside handle (L, R).
	 *
	 * However, the inside handles do not work if a child lock switch is activated.
	 * In order for the sliding doors to open, the gear shift must be in park, and the master unlock switch must be activated.
	 */
	public static String problem8_carDoorControl(
			boolean dashboardLeft,
			boolean dashboardRight, 
			boolean childLock, 
			boolean masterUnlock,

			boolean insideLeftLatch, 
			boolean outsideLeftLatch, 
			boolean insideRightLatch,
			boolean outsideRightLatch, 
			String gearshift
			) {

		boolean leftDoorOpens = false;
		boolean rightDoorOpens = false;

		if ("P".equals(gearshift) && masterUnlock) {
			if (dashboardLeft || outsideLeftLatch || (!childLock && insideLeftLatch)) {
				leftDoorOpens = true;
			}

			if (dashboardRight || outsideRightLatch || (!childLock && insideRightLatch)) {
				rightDoorOpens = true;
			}
		}

		if (leftDoorOpens && rightDoorOpens) {
			return "Both doors open";
		} else if (leftDoorOpens) {
			return "Left door opens";
		} else if (rightDoorOpens) {
			return "Right door opens";
		} else {
			return "No door opens";
		}
//		if (!Objects.equals(gearshift, "P") || !masterUnlock) {
//			return "No door opens";
//		} else {
//			if (childLock) {
//				if (outsideLeftLatch || outsideRightLatch) {
//					return "Both doors open";
//				} else {
//
//				}
//			}
//		}
//
//		return "Left door opens", "Right door opens", "Both doors open", ;
	}
	
	
	/**
	 * Reads the French name of a country from the user and adds the article
	 * 
	 * @param in the Scanner to be used for user input
	 * 
	 *           To run this method using the keyboard for user input, call it like
	 *           this: problem9_getFrenchName(new Scanner(System.in));
	 */
	public static void problem9_getFrenchName(Scanner in) {
		Set<String> masculineExceptions =
				new HashSet<>(Arrays.asList("Belize", "Cambodge", "Mexique", "Mozambique", "Zaire", "Zimbabwe"));
		Set<String> pluralCountries = new HashSet<>(Arrays.asList("Etats-Unis", "Pays-Bas", "pays-bas", "etats-unis"));

		System.out.print("Enter country name: ");
		String name = in.next();
		String article;

		if (pluralCountries.contains(name)) {
			article = "les ";
		} else if (startsWithVowel(name)) {
			article = "l'";
		} else if (name.endsWith("e") && !masculineExceptions.contains(name)) {
			article = "la ";
		} else {
			article = "le ";
		}

		System.out.print(article + name);
	}

	private static boolean startsWithVowel(String word) {
		return word.matches("^[AEIOUaeiou].*");
	}
	
	
	/**
	 * Reads a value and a unit (either dB or Pa) from the user, then prints a
	 * string indicating which sound level category the sound falls into.
	 * 
	 * When you print the formatted number, use print instead of println.
	 * 
	 * To run this method using the keyboard for user input, call it like this:
	 * problem10_getSoundLevel(new Scanner(System.in));
	 * 
	 * @param in the Scanner to be used for user input
	 */
	public static void problem10_getSoundLevel(Scanner in) {
		System.out.print("Enter sound level and unit (dB or Pa): ");
		double value = in.nextDouble();
		String unit = in.next();
		double soundLevelDb;

//		System.out.print(value + "space" + unit);
			if (!unit.equals("dB") && !unit.equals("Pa") && value < 0) {
				System.out.print( "Invalid unit and sound level");
				return;
			} else if (value < 0){
				System.out.print("Invalid sound level");
				return;
			} else if (!unit.equals("dB") && !unit.equals("Pa")){
				System.out.print("Invalid unit");
				return;
			}

		if (unit.equals("Pa")) {
			soundLevelDb = 20 * Math.log10(value / 2e-5);
		} else {
			soundLevelDb = value;
		}

		System.out.print(getSoundDescription(soundLevelDb));
	}

	private static String getSoundDescription(double soundLevelDb) {
		if (soundLevelDb >= 130) {
			return "Threshold of pain";
		} else if (soundLevelDb >= 120) {
			return "Possible hearing damage";
		} else if (soundLevelDb >= 100) {
			return "Jack hammer at 1 m";
		} else if (soundLevelDb >= 90) {
			return "Traffic on a busy roadway at 10 m";
		} else if (soundLevelDb >= 60) {
			return "Normal conversation";
		} else if (soundLevelDb >= 30) {
			return "Calm library";
		} else {
			return "Light leaf rustling";
		}
	}

	public static void main(String args[]) {
	}

}
