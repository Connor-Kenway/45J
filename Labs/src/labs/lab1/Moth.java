package labs.lab1;

/**
 * 
 * A moth flying along a straight line
 *
 */
public class Moth {
	private double currentPosition, lightPosition;

	/**
	 * Constructs a Moth with an initial position (distance from a fixed origin)
	 * 
	 * @param initialPosition the initial position of the moth (assume always >= 0)
	 */
	public Moth(double initialPosition) {
		currentPosition = initialPosition;
	}


	/**
	 * Moves the Moth toward a light, causing its new position to be halfway between
	 * its old position and the position of the light source
	 * 
	 * @param lightPosition the position of the light (assume always >= 0)
	 */
	public void moveToLight(double lightPosition) {
		currentPosition = (lightPosition + currentPosition) / 2;
	}


	/**
	 * Returns the Moth's current position
	 * 
	 * @return the Moth's current position
	 */
	public double getPosition() {
		return currentPosition;
	}

}
