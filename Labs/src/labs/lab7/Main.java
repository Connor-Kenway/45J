package labs.lab7;

public class Main {

	/**
	 * Given a string that contains a single pair of parentheses, compute recursively
	 * a new string made of only the parentheses and their contents, so "xyz(abc)123"
	 * yields "(abc)". You can assume that the string will always contain a single
	 * pair of parentheses, with the opening parenthesis appearing before the
	 * closing parenthesis.
	 * 
	 * @param str	the input string
	 * 
	 * @return	a new string made of only the parentheses and their contents
	 */
	public static String problem1_parenPart(String str) {
		return problem1_parenPart_rec(str, 0, false);
    }

	private static String problem1_parenPart_rec(String s, int index, boolean capturing) {
		if (index >= s.length()) {
			return "";
		} else if (s.charAt(index) == ')' && capturing) {
			return ")";
		} else if (s.charAt(index) == '(') {
			return "(" + problem1_parenPart_rec(s, index + 1, true);
		} else if (capturing) {
			return s.charAt(index) + problem1_parenPart_rec(s, index + 1, true);
		} else {
			return problem1_parenPart_rec(s, index + 1, false);
		}
	}

	
	
	/**
	 * We'll say that a "double" in a string is two instances of a char, separated by a char. 
	 * So in "AxA", the A's make a double. Doubles can overlap, so "AxAxA" contains 3 doubles -- 2 for A and 1 for x. 
	 * This method recursively computes the number of doubles in the given string.
	 * 
	 * @param str	the string to check for doubles
	 * @return		the number of doubles in the given string
	 */
	public static int problem2_countDoubles(String str) {
		if (str.length() < 3) {
			return 0;
		}
		int count = (str.charAt(0) == str.charAt(2)) ? 1 : 0;

		return count + problem2_countDoubles(str.substring(1));
	}
	
	
	/**
	 * Given a string and a non-empty substring sub, compute recursively the number
	 * of times that sub appears in the string, without the sub-strings overlapping.
	 * 
	 * @param str the string in which to count occurrences of sub
	 * @param sub the substring to count
	 * 
	 * @return the number of times that sub appears in the string, without the sub
	 *         strings overlapping
	 */
	public static int problem3_countSubs(String str, String sub) {
		if (str.length() < sub.length()) {
			return 0;
		}

		int count = 0;
		if (str.startsWith(sub)) {
			count = 1 + problem3_countSubs(str.substring(sub.length()), sub);
		} else {
			count = problem3_countSubs(str.substring(1), sub);
		}

		return count;
	}
}