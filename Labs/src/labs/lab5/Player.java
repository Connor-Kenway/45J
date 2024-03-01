package labs.lab5;

/**
 * Player in the battle game
 *
 */
public class Player {

	// ADD YOUR INSTANCE VARIABLES HERE
	String name;
	int StrengthPoints;
	int ammo;
	/**
	 * Constructs a new Player with the given name, 0 strength points, and 0 ammo
	 * 
	 * @param name name of the player
	 */
	public Player(String name) {
		this.name = name;
		this.StrengthPoints = 0;
		this.ammo = 0;
	}


	public String getName() {
		return name;
	}


	public int getStrengthPoints() {
		return StrengthPoints;
	}


	public int getAmmo() {
		return ammo; // FIX ME
	}


	/**
	 * If the item is a PowerUp: Collects the given PowerUp if it's not already
	 * collected, and increments the player's strength points by the number of
	 * points the PowerUp is worth
	 * 
	 * If the item is Ammo: Collects the given ammo if it's not already collected,
	 * and if the player has enough strength points (each pound of ammo requires 10
	 * strength points); adds to the player's ammo the number of items in the ammo
	 * 
	 * @param c the item to collect
	 * 
	 * @return whether or not the item was collected
	 */
	public boolean collectItem(Collectible c) {
		if (c instanceof PowerUp) {
			boolean isTaken = c.isCollected();
			StrengthPoints += c.collect();
			return !isTaken;
		}
		if (c instanceof Ammo) {
			boolean isTaken = c.isCollected();
			double requiredPower = ((((Ammo) c).weight) * 10);
			if (getStrengthPoints() == 0) {return isTaken;}

			if (getStrengthPoints() > requiredPower) {
				ammo += c.collect();
				return !isTaken;
			} else {
				return isTaken;
			}
		}
		return c.isCollected();
	}


	/**
	 * If the Player has ammo, attacks the given enemy with one ammo (and uses up
	 * one ammo)
	 * 
	 * @param enemy the Enemy to attack
	 * 
	 * @return whether or not the Enemy was attacked
	 */
	public boolean attackEnemy(Enemy enemy) {
		if (ammo > 0) {
			ammo -= 1;
			StrengthPoints += enemy.attack();
			return true;
		}
		return false;
	}

}