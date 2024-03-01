package labs.lab5;

/**
 * A Bugaboo enemy
 *
 */

public class Bugaboo extends Enemy {

	// ADD YOUR INSTANCE VARIABLES HERE
	double strength;

	/**
	 * Constructs a new Bugaboo with the given strength
	 *
	 * @param strength <-- added
	 */
	public Bugaboo(double strength) {
		this.strength = strength;
	}


	public double getStrength() {
		return strength;
	}


	/**
	 * 1) decreases the Bugaboo's strength by 25%; 2) returns 0 (no strength points
	 * awarded or deducted to the player attacking this Bugaboo)
	 * 
	 * @return 0 (no strength points awarded or deducted to the player attacking
	 *         this Bugaboo)
	 */
	public int attack() {
		strength -= strength * .25;
		return 0;
	}


	/**
	 * increases strength by 15%
	 */
	public void advanceTime() {
		strength += strength * 0.15;
	}
}