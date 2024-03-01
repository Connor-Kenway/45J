package labs.lab6;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A vending machine.
 */
public class VendingMachine {

	private List<VendingMachineProduct> products; // the products in the machine
	public CoinBox storedCoins; // the coins that have already been used to purchase a product
	public CoinBox currentCoins; // the coins that have been inserted but have not yet been used to purchase a
									// product
	public Map<VendingMachineProduct, Integer> expectedProducts;

	/**
	 * Constructs a VendingMachine object with no products or coins
	 */
	public VendingMachine() {
		this.products = new ArrayList<>();
		this.storedCoins = new CoinBox();
		this.currentCoins = new CoinBox();
		this.expectedProducts = new HashMap<>();
	}


	/**
	 * Gets the type of products in the vending machine.
	 * 
	 * @return a list of products in this machine
	 */
	public List<VendingMachineProduct> getProductTypes() {
		return products;
	}


	/**
	 * Adds a product to the vending machine.
	 * 
	 * @param p        the product to add
	 * @param quantity the quantity
	 */
	public void addProduct(VendingMachineProduct p, int quantity) {
		products.add(p);
		for (int i = 0; i < quantity; ++i) {
			expectedProducts.put(p, quantity);
		}
	}


	/**
	 * Adds the coin to the vending machine, and returns the total value of coins
	 * that have been inserted but not yet used to buy a product
	 * 
	 * @param c the coin to add
	 * @return the total value of coins that have been inserted but not yet used to
	 *         buy a product
	 */
	public double addCoin(Coin c) {
		currentCoins.addCoin(c);
		return currentCoins.coins;
	}


	/**
	 * Buys a product from the vending machine, causing all the coins that have been
	 * inserted since the last purchase to be stored in the machine and unavailable
	 * to use for other purchases.
	 * 
	 * @param p the product to buy
	 * @return "OK" if the product was purchased, "Insufficient money" if the
	 *         product exists but there is not enough to purchase the product, or
	 *         "No such product" if the product doesn't exist in the machine
	 */
	public String buyProduct(VendingMachineProduct p) {
		if (expectedProducts.containsKey(p)) {
			if (p.price <= currentCoins.coins) {
				products.remove(p); // take the product out of the machine
				storedCoins.addCoins(currentCoins); // store currentCoins into storedCoins
				currentCoins.removeAllCoins(); // remove all currentCoins
				if (expectedProducts.get(p)-1 <= 0) {
					expectedProducts.remove(p);
				} else {
					expectedProducts.replace(p, expectedProducts.get(p)-1);
				}
				return "OK";
			} else {
				return "Insufficient money";
			}
		} else {
			return "No such product";
		}
	}


	/**
	 * Removes the stored money from the vending machine.
	 * 
	 * @return the amount of money removed
	 */
	public double removeStoredMoney() {
		double temp = storedCoins.coins;
		storedCoins.removeAllCoins();
		return temp;
	}

}
