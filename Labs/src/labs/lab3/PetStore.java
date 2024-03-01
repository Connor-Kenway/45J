package labs.lab3;

import java.util.ArrayList;

/**
 * Represents Robert's pet store
 */
public class PetStore {
	// ADD YOUR INSTANCE VARIABLES HERE
	ArrayList<Customer>customers;
	/**
	 * Constructor that creates this PetStore
	 */
	public PetStore() {
		customers = new ArrayList<>();
	}
	
	
	/**
	 * Adds a new Customer to the PetStore
	 * 
	 * @param c	new customer
	 */
	public void addCustomer(Customer c) {
		customers.add(c);
	}
	
	
	/**
	 * Returns the name of the Customer who has spent the most money. If there 
	 * are no customers, return the empty string. If there is more than one
	 * "best customer," returns any one of them.
	 * 
	 * @return	the best customer in the store
	 */
	public String getNameOfBestCustomer() {
		double BestCustomerSpent = 0.0;
		String bestCustomer = "";
		if (customers.isEmpty()) {
			return "";
		}
		for (int i = 0; i < customers.size() ; ++i) {
			if (customers.get(i).getAmountSpent() > BestCustomerSpent) {
				bestCustomer = customers.get(i).getName();
				BestCustomerSpent = customers.get(i).getAmountSpent();
			}
		}
		return bestCustomer;
	}
}