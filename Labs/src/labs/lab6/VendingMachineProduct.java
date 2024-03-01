package labs.lab6;


/**
 * A product in a vending machine.
 */
public class VendingMachineProduct {

	// ADD YOUR INSTANCE VARIABLES HERE
	String description;
	double price;

	/**
	 * Constructs a VendingMachineProduct object
	 * 
	 * @param aDescription the description of the product
	 * @param aPrice       the price of the product
	 */
	public VendingMachineProduct(String aDescription, double aPrice) {
		description = aDescription;
		price = aPrice;
	}


	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * Gets the price.
	 * 
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}


	/**
	 * Determines if this vending machine product is the same as the other 
	 * vending machine product.
	 * 
	 * @param other the other product
	 * @return true if the products have the same description and price, false otherwise
	 */
	@Override
	public boolean equals(Object other) {
		if (this == other) return true;
		if (other == null || getClass() != other.getClass()) return false;

		VendingMachineProduct otherProduct = (VendingMachineProduct) other;

		return description.equals(otherProduct.description) && price == otherProduct.price;
	}


	/**
	 * Returns a string representation of the product consisting of the description,
	 * " @ $", and the prices, formatted with two decimal places after the decimal
	 * point
	 */
	@Override
	public String toString() {
		return description + " @ $" + price;
	}

}
