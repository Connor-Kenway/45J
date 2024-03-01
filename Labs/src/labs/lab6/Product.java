package labs.lab6;

/**
 * Represents a single product.
 */
public class Product {
	// ADD YOUR INSTANCE VARIABLES EHRE
	String name;
	double price;
	int quantity;

	/**
	 * Constructs a Product.
	 * 
	 * @param name    	product name
	 * @param price	  	price of product
	 * @param quantity	quantity of product
	 */
	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
//		System.out.println(this.quantity);
	}

	/**
	 * Retrieve product name.
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Retrieve product price.
	 * 
	 * @return product price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Retrieve quantity.
	 * 
	 * @return quantity of product
	 */
	public int getQuantity() {
		return quantity;
	}
	
	
	/**
	 * Returns the name, price, and quantity, each separated by a comma and
	 * space
	 */
	@Override
	public String toString() {
		return name + ", " + price + ", " + quantity;
	}
	
	
	/**
	 * Returns true if the given object is a Product with the same instance
	 * variable values as this one
	 */
	@Override
	public boolean equals(Object otherObj) {
		if (this == otherObj) return true;
		if (otherObj == null || getClass() != otherObj.getClass()) return false;
		Product product = (Product) otherObj;
		return Double.compare(product.price, price) == 0 &&
				quantity == product.quantity &&
				name.equals(product.name);
	}
}
