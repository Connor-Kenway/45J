package labs.lab5;

/**
 * A demogorgon enemy
 *
 */

public class Demogorgon extends Enemy {

	// ADD YOUR INSTANCE VARIABLES HERE
	double weight;
	/**
	 * Constructs a new Demogorgon with the given weight
	 * 
	 * @param weight <
	 */
	public Demogorgon(double weight) {
		this.weight = weight;
	}


	public double getWeight() {
		return weight;
	}


	/**
	 * 1) decreases the Demogorgon's weight by 10%; 2) decrements the Demogorgon's
	 * health by 15; 3) returns 0 (no strength points awarded or deducted to the
	 * player attacking this Demogorgon)
	 * 
	 * @return 0 (no strength points awarded or deducted to the player attacking
	 *         this Demogorgon)
	 */
	public int attack() {
		weight -= weight * 0.1;
		super.setHealth(this.health-=15);
		return 0;
	}


	/**
	 * 1) increases the Demogorgon's weight by 5%; 2) increments the Demogorgon's
	 * health by 10
	 */
	public void advanceTime() {
		weight += weight * 0.05;
		super.setHealth(this.health += 10);
	}

}