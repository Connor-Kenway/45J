package labs.lab1;

/**
 * A savings account has a balance that can be changed by deposits and
 * withdrawals.
 */
public class SavingsAccount {

	// ADD YOUR INSTANCE VARIABLES HERE
	private double balance, interestRate;

	/**
	 * Constructs a savings account with a given balance
	 * 
	 * @param initialBalance the initial balance
	 * @param rate           the interest rate in percent
	 */
	public SavingsAccount(double initialBalance, double rate) {
		balance = initialBalance;
		interestRate = rate;
	}


	/**
	 * Deposits money into the savings account.
	 * 
	 * @param amount the amount to deposit
	 */
	public void deposit(double amount) {
		balance = balance + amount;
	}


	/**
	 * Withdraws money from the savings account,
	 * as long as the withdrawal would not result
	 * in a negative balance
	 * 
	 * @param amount the amount to withdraw
	 */
	public void withdraw(double amount) {
		if (balance - amount < 0) {

		} else {
			balance = balance - amount;
		}
	}


	/**
	 * Gets the current balance of the savings account.
	 * 
	 * @return the current balance
	 */
	public double getBalance() {
		return balance;
	}


	/**
	 * Adds interest to the savings account.
	 */
	public void addInterest() {
		balance = balance * interestRate/100 + balance;
	}

}