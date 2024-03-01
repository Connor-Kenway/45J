package labs.lab3;

import java.util.Arrays;

public class Main {

	/**
	 * An uppercase 'E' in a string is "happy" if there is another uppercase 'E'
	 * immediately to its left or right. Returns true if all the E's in the given
	 * string are happy. (A string with no 'E' in it returns true.)
	 * 
	 * @param str
	 * @return whether or not all E's in the string are happy
	 */
	public static boolean problem1_EHappy(String str) {
		if (str.isEmpty()) {
			return true;
		}
		if (str.equals("E")) { return false;}

		if (str.charAt(0) == 'E' && str.charAt(1) != 'E'){ return false;}

		for (int i = 1; i < str.length()-1; ++i) {
			if (str.charAt(i) == 'E' && str.charAt(i - 1) != 'E' && str.charAt(i + 1) != 'E') {
				return false;
			}
		}
		int lastIndex = str.length() - 1;
        return lastIndex <= 0 || str.charAt(lastIndex) != 'E' || str.charAt(lastIndex - 1) == 'E';
    }
	
	
	/**
	 * Given a string, returns true if the number of appearances of "are"
	 * anywhere in the string is equal to the number of appearances of 
	 * "not" anywhere in the string (case sensitive).
	 * 
	 * @param str	the input strings
	 * 
	 * @return	true if the number of appearances of "are"
	 * anywhere in the string is equal to the number of appearances of 
	 * "not" anywhere in the string (case sensitive)
	 */
	public static boolean problem2_equalAreNot(String str) {
		int areCount = 0;
		int notCount = 0;
		for (int i = 0; i < str.length(); i++) {
			if (i + 3 <= str.length() && str.substring(i, i + 3).equals("are")) {
				areCount++;
			}
			if (i + 3 <= str.length() && str.substring(i, i + 3).equals("not")) {
				notCount++;
			}
		}

		return areCount == notCount;
	}
	
	
	/**
	 * Given a string, return the sum of the digits 0-9 that appear in the string,
	 * ignoring all other characters. Return 0 if there are no digits in the string.
	 * (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1',
	 * .. '9'. Integer.parseInt(String) converts a string to an int.)
	 * 
	 * @param str the string from which to sum the digits
	 * @return the sum of the digits 0-9 that appear in the string
	 */
	public static int problem3_sum(String str) {
		int totalSum = 0;
		for (int i = 0; i < str.length(); ++i) {
			char ch = str.charAt(i);
			if (Character.isDigit(ch)) {
				totalSum += ch - '0';
			}
		}
		return totalSum;
	}
	
	
	/**
	 * Returns the minimum number of twists to unlock a lock, based on the starting
	 * and target values.
	 * 
	 * Assume input values will never start with 0 except for the case 0000.
	 * 
	 * @param starting	the current numbers of the lock
	 * @param target	the combination required to unlock the lock
	 * 
	 * @return	the minimum number of twists to unlock the lock
	 */
	public static int problem5_getNumTwists(int starting, int target) {
		int totalTwists = 0;
		String startingString = String.valueOf(starting);
		String targetString = String.valueOf(target);

		if (starting == 0) {
			return 4;
		}

		for (int i = 0 ; i < 4 ; ++i) {
			char s = startingString.charAt(i);
			char t = targetString.charAt(i);
			int diff = Math.abs(Integer.parseInt(String.valueOf(s)) - Integer.parseInt(String.valueOf(t)));
			if (diff > 5) {
				diff = 10 - diff;
			}
			totalTwists += diff;
		}
		return totalTwists;
	}
	
	
	/**
	 * Takes an array of ints and returns an array that contains the exact same numbers 
	 * as the given array, but rearranged so that all the even numbers come before all
	 * the odd numbers
	 * 
	 * @param nums	the input array
	 * 
	 * @return	the rearranged array with all even numbers coming before all odd numbers
	 */
	public static int[] problem6_evenOdd(int[] nums) {
		int evenPointer = 0;
		int oddPointer = nums.length - 1;

		while (evenPointer < oddPointer) {
			if (nums[evenPointer] % 2 == 0) {
				evenPointer++;
			} else if (nums[oddPointer] % 2 == 1) {
				oddPointer--;
			} else {
				int temp = nums[evenPointer];
				nums[evenPointer] = nums[oddPointer];
				nums[oddPointer] = temp;
				evenPointer++;
				oddPointer--;
			}
		}
//		System.out.println(Arrays.toString(nums));
		return nums;
	}
	
	
	/**
	 * Say that a "clump" in an array is a series of 2 or more adjacent elements of
	 * the same value. Return the number of clumps in the given int array.
	 * 
	 * @param nums the input array
	 * 
	 * @return the number of clumps in the input array
	 */
	public static int problem7_countClumps(int[] nums) {
		int clumps = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				clumps++;
				while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
					i++;
				}
			}
		}
		return clumps;

//		if (nums.length < 2) { return 0; }
//		int clumps = 0;
//		boolean clumpy = false;
//		int firstPtr = 0;
//		int secondPtr = 1;
//		while (firstPtr < nums.length && secondPtr < nums.length){
//			while (clumpy) {
//				if (secondPtr >= nums.length) {
//					return clumps;
//				}
//				if (nums[firstPtr] == nums[secondPtr]) {
//					secondPtr++;
//				} else {
//					secondPtr += 2;
//					firstPtr = secondPtr-1;
//					clumpy = false;
//				}
//			}
//
//			if (nums[firstPtr] != nums[secondPtr]) {
//				firstPtr++;
//				secondPtr++;
//			} else {
//				clumps++;
//				clumpy = true;
//				secondPtr++;
//			}
//		}
//
//		System.out.println(clumps);
//		return clumps;
	}

	public static void main(String[] args) {
		System.out.print(problem1_EHappy("E"));
	}
}