package labs.lab1;

import java.math.BigDecimal;

/**
 * This class models a simple letter.
 */
public class Letter {
	String sender, recipient, letter;

	/**
	 * Constructs a letter with a given sender and recipient.
	 * 
	 * @param from the sender
	 * @param to   the recipient
	 */
	public Letter(String from, String to) {
		sender = from;
		recipient = to;
		this.addLine("Dear " + recipient + ":\n");
	}

	/**
	 * Adds a line to the end of the body of this letter
	 * 
	 * @param	line	line to add
	 */
	public void addLine(String line) {
		if (letter == null) {
			letter = line + '\n';
		} else {
			letter = letter + line + '\n';
		}
	}

	/**
	 * Gets the entire text of this letter
	 * 
	 * @return	the entire text of this letter
	 */
	public String getText() {
		this.addLine("\nSincerely, \n\n" + sender);
		return letter;
	}
	public static void main(String[] args) {
		Letter dearJohnLetter = new Letter("Mary", "John");
		dearJohnLetter.addLine("I am sorry we must part.");
		dearJohnLetter.addLine("I wish you all the best.");

		String message = dearJohnLetter.getText();
		System.out.println(message);

	}
}


