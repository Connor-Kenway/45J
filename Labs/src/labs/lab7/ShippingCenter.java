package labs.lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Class for simulating a shipping center using stacks of products with
 * descriptions as representation.
 */
public class ShippingCenter {

	private Stack<String> shippingStack; // products ready to be shipped
	private Stack<String> temporaryStack; // products placed on a temporary stack while shuffling around products ready
											// to be shipped

	/**
	 * Constructs a new shipping center with empty stacks
	 */
	public ShippingCenter() {
		shippingStack = new Stack<>();
		temporaryStack = new Stack<>();
	}


	/**
	 * Returns a string containing the contents of the storage stack, each item
	 * separated by a comma and space
	 * 
	 * @return a string containing the contents of the storage stack, each item
	 *         separated by a comma and space
	 */
	public String getShippingStack() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < shippingStack.size(); i++) {
			sb.append(shippingStack.get(i));
			if (i < shippingStack.size() - 1) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}


	/**
	 * Returns a string containing the contents of the temporary stack, each item
	 * separated by a comma and space
	 * 
	 * @return a string containing the contents of the temporary stack, each item
	 *         separated by a comma and space
	 */
	public String getTemporaryStack() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < temporaryStack.size(); i++) {
			sb.append(temporaryStack.get(i));
			if (i < temporaryStack.size() - 1) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}


	/**
	 * Add the given product to the shipping stack. Returns a log of the process.
	 * 
	 * @param product description of product
	 * @return a log of the process
	 */
	public List<String> add(String product) {
		List<String> log = new ArrayList<>();
		if (shippingStack.search(product) != -1) {
			log.add("That product is already on the shipping stack.");
			return log;
		}
		shippingStack.push(product);
		log.add("Shipping stack: " + getShippingStack());
		log.add("Temporary stack: " + getTemporaryStack());
		return log;
	}


	/**
	 * Ships the given product (removes it from the shipping stack if it's on the
	 * shipping stack). Returns a log of the process
	 * 
	 * @param product description of product
	 * @return a log of the process (see example and test file for format)
	 */
	public List<String> ship(String product) {
		List<String> log = new ArrayList<>();
		boolean found = false;

		while (!shippingStack.isEmpty() && !found) {
			String topProduct = shippingStack.peek();

			if (topProduct.equals(product)) {
				found = true;
				shippingStack.pop();

				if (!temporaryStack.isEmpty()) {
					while (!temporaryStack.isEmpty()) {
						shippingStack.push(temporaryStack.pop());
						log.add("Shipping stack: " + getShippingStack());
						log.add("Temporary stack: " + getTemporaryStack());
					}
				} else {
					log.add("Shipping stack: " + getShippingStack());
					log.add("Temporary stack: " + getTemporaryStack());
				}

			} else {
				temporaryStack.push(shippingStack.pop());
				log.add("Shipping stack: " + getShippingStack());
				log.add("Temporary stack: " + getTemporaryStack());
			}
		}

		if (!found) {
			log = new ArrayList<>();
			log.add("That product is not on the shipping stack.");
		}

		return log;
	}
}
