package labs.lab6;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.LinkedHashMap;

public class ProductDB {

	private Map<String, Product> products = new LinkedHashMap<>();
	private final String productsFileName;

	/**
	 * Constructor that reads in the product data from a file
	 * 
	 * @param productsFileName name of file with product data
	 */
	public ProductDB(String productsFileName) {
		this.productsFileName = productsFileName;
		try {
			Scanner scanner = new Scanner(new File(productsFileName));
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] parts = line.split(";");
				String name = parts[0].trim();
				double price = Double.parseDouble(parts[1].trim());
				double quantity = Double.parseDouble(parts[2].trim());
				int intQuantity = (int) quantity;
				products.put(name, new Product(name, price, intQuantity));
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.print("File: " + productsFileName + " not found");
		}
	}


	/**
	 * Searches for the product with the given name and returns it if found,
	 * otherwise returns null.
	 * 
	 * @param productName name of product to search for
	 * 
	 * @return product with given name, or null if not found
	 */
	public Product findProduct(String productName) {
		return products.get(productName);
	}


	/**
	 * Adds a new product to the products DB if a product with the given name
	 * doesn't already exist
	 * 
	 * @param name     name of product
	 * @param price    price of product
	 * @param quantity quantity of product
	 */
	public void addProduct(String name, double price, int quantity) {
		if (!products.containsKey(name)) {
			Product newProduct = new Product(name, price, quantity);
			products.put(name, newProduct);
			try (PrintWriter out = new PrintWriter(productsFileName)) {
				for (Product product : products.values()) {
					out.printf("%s;%.2f;%d\n", product.getName(), product.getPrice(), product.getQuantity());
				}
			} catch (FileNotFoundException e) {
				System.out.print("File: " + productsFileName + " not found");
			}
		}
	}

	public static void main(String[] args) {
		ProductDB db = new ProductDB("res/products.txt");
		System.out.println(db.findProduct("Blue plaid bow tie collar")); // returns the product "Blue plaid bow tie collar" with price 29.95 and quantity 6
		System.out.println(db.findProduct("Red bandana")); // returns the product "Red bandana" with price 3.99 and quantity 16
		System.out.println(db.findProduct("White porcelain food and water bowl set")); // returns the product "White porcelain food and water bowl set" with price 23.00 and quantity 8
		System.out.println(db.findProduct("XL tan fluffy dog bed"));  // returns the product "XL tan fluffy dog bed" with price 75.25 and quantity 2
		System.out.println(db.findProduct("stuffed sloth")); // returns null
		db.addProduct("stuffed sloth", 9.99, 4);
		System.out.println(db.findProduct("stuffed sloth")); // returns the product "stuffed sloth" with price 9.99 and quantity 4
		db.addProduct("stuffed sloth", 10.99, 16);
		db.addProduct("stuffed sloth", 0.99, 1);
		System.out.println(db.findProduct("stuffed sloth")); // returns the product "stuffed sloth" with price 9.99 and quantity 4
	}
}
