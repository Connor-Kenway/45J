package labs.lab3;

import java.time.LocalDate;

/**
 * Represents a credit card
 *
 */
public class CreditCard {

	long cardNumber;
	LocalDate newDate;
	LocalDate expirationDate;

	
	/**
	 * Constructs a credit card object with the given number and expiration
	 * date
	 * 
	 * Assume the number passed in will always have 16 digits and will not
	 * start with 0. 
	 * 
	 * Assume the date passed in will always be a valid date.
	 * 
	 * @param number	the credit card number
	 * @param expDate	the credit card expiration date
	 */
	public CreditCard(long number, LocalDate expDate) {
		cardNumber = number;
		newDate = expDate;
	}


	/**
	 * Returns the credit card number
	 * 
	 * @return	the credit card number
	 */
	public long getNumber() {
		return cardNumber;
	}


	/**
	 * Returns the credit card expiration date
	 * 
	 * @return	the credit card expiration date
	 */
	public LocalDate getExpirationDate() {
		return newDate;
	}
	
	
	/**
	 * Returns a string containing the card number, with a space inserted
	 * between every 4 digits
	 * 
	 * @return	the card number, with a space inserted between every 4 digits
	 */
	public String getNumberWithSpaces() {
		String stringNumber = Long.toString(cardNumber);
		String newStringNumber = "";
		char Space = ' ';
		for (int i = 0; i < stringNumber.length(); ++i) {
			if (i % 4 == 0 && i != 0) {
				newStringNumber += Space;
			}
			newStringNumber += stringNumber.charAt(i);
		}
		return newStringNumber; // FIX ME
	}


	/**
	 * Returns true if both the card number and expiration date are valid,
	 * false otherwise
	 * 
	 * @return	whether card is valid
	 */
	public boolean isValid() {
		int totalSum = 0;
		String stringNumber = Long.toString(cardNumber);
		for (int i = 0; i < stringNumber.length(); ++i) {
			totalSum += Integer.parseInt(stringNumber.substring(i, i+1));
			if ((i+1) % 2 == 0) {
				totalSum += Integer.parseInt(stringNumber.substring(i, i+1));
				if (Integer.parseInt(stringNumber.substring(i, i+1)) > 5) {
					totalSum += 1;
				}
			}
		}
		return totalSum % 3 == 0 && newDate.isAfter(LocalDate.now());
	}

}