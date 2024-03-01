package labs.lab4;

import java.util.HashSet;
import java.util.Set;

/**
 * A class for a customer in a store that discounts 10% on every purchase
 * after they have spent at least $100 and shopped in at least 3 different stores.
 */
public class Customer {

	// ADD YOUR INSTANCE VARIABLES HERE
//	private int distinctShopsCount;
	private double totalSpent;
	private boolean discountApplied;
	private Set<Integer> uniqueStores;

	public Customer() {
		totalSpent = 0;
		uniqueStores = new HashSet<>();
		discountApplied = false;
	}
	

	/**
	 * 
	 * @param purchaseAmount
	 * @param storeNum	Each store is identified by a unique integer
	 * @return	the purchase amount for this purchase, with any discounts applied
	 */
	public double makePurchase(double purchaseAmount, int storeNum) {
		totalSpent += purchaseAmount;
		if (discountApplied) {
			totalSpent += purchaseAmount * 0.9;
			return purchaseAmount * 0.9;
		} else {
			uniqueStores.add(storeNum);
			totalSpent += purchaseAmount;

			if (totalSpent >= 100 && uniqueStores.size() >= 3) {
				discountApplied = true;
			}
			return purchaseAmount;
		}
    }
}
