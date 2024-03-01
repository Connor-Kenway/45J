package labs.lab4;

import static org.junit.Assert.*;

import org.junit.Test;


public class CustomerTest {
	private final double EPSILON = 1e-3;


	@Test
    public void testTotalOver100NumStoresLessThan3() {
		Customer c1 = new Customer();
		assertEquals(50.0, c1.makePurchase(50, 3), EPSILON);
		assertEquals(50.0, c1.makePurchase(50, 3), EPSILON);
		assertEquals(50.0, c1.makePurchase(50, 3), EPSILON);
    }
	
	
	@Test
	public void testTotalOver100NumStoresGreaterThan3() {
		Customer c2 = new Customer();
		c2.makePurchase(25, 1); // Store 1
		c2.makePurchase(25, 2); // Store 2
		c2.makePurchase(25, 3); // Store 3, total now over 75
		assertEquals( 45.0, c2.makePurchase(50, 4), EPSILON);
	}
	
	
	@Test
	public void testTotalLessThan100NumStoresGreaterThan3() {
		Customer c3 = new Customer();
		c3.makePurchase(10, 1); // Store 1
		c3.makePurchase(10, 2); // Store 2
		c3.makePurchase(10, 3); // Store 3
		c3.makePurchase(10, 4); // Store 4, total now 40 but more than 3 stores
		assertEquals(10.0, c3.makePurchase(10, 5), 0.01);
	}
}