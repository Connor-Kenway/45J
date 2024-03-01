package labs.lab3;

/**
 * Represents a customer in Robert's pet store
 */
public class Customer {
	
	// ADD YOUR INSTANCE VARIABLES HERE
	String cName;
	double totalSpend;

	/**
	 * Constructor that creates this Customer
	 * 
	 * @param name	name of customer
	 */
	public Customer(String name) {
		cName = name;
	}
	
	
	/**
	 * @return	name of customer
	 */
	public String getName() {
		return cName;
	}
	
	
	/**
	 * @return	amount the customer has spent
	 */
	public double getAmountSpent() {
		return totalSpend;
	}
	
	
	/**
	 * Adds an amount to the customer's amount spent
	 * 
	 * @param amount	amount to add
	 */
	public void addSale(double amount) {
		totalSpend += amount;
	}
}