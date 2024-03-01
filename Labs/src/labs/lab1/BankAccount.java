package labs.lab1;

import static java.lang.Math.max;

/**
 * A bank account has a balance that can be changed by deposits and withdrawals.
 */

/**
 * abstraction and encapsulation
 */
public class BankAccount {
	// ADD YOUR INSTANCE VARIABLES HERE
	private double balance;
	private int transactions;
	private double transactionsFee;

	/**
	 * Constructs a bank account with a zero balance.
	 * 
	 * @param free number of free transactions
	 */
	public BankAccount(int free) {
		balance = 0;
		transactions = transactions - free;
	}

	/**
	 * Constructs a bank account with a given balance.
	 * 
	 * @param initialBalance the initial balance
	 * @param free           number of free transactions
	 */
	public BankAccount(double initialBalance, int free) {
		balance = initialBalance;
		transactions = transactions - free;
	}

	/**
	 * Deposits money into the bank account.
	 * 
	 * @param amount the amount to deposit
	 */
	public void deposit(double amount) {
		balance = balance + amount;
		transactions = transactions + 1;
	}

	/**
	 * Withdraws money from the bank account.
	 * 
	 * @param amount the amount to withdraw
	 */
	public void withdraw(double amount) {
		balance = balance - amount;
		transactions = transactions + 1;
	}

	/**
	 * Gets the current balance of the bank account.
	 * 
	 * @return the current balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Sets the transaction fee.
	 * 
	 * @param fee new transaction fee
	 */
	public void setTransactionFee(double fee) {
		transactionsFee = fee;
	}

	/**
	 * Applies monthly transaction charge.
	 */
	public void deductMonthlyCharge() {
		balance = balance - transactionsFee * transactions;
		transactions = 0;
	}
}
