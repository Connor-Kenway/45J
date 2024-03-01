package labs.lab5;

import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;

/**
 * A goblin enemy
 *
 */

public class Goblin extends Enemy {

	// ADD YOUR INSTANCE VARIABLES HERE
	String color;
	String[] skin = {"purple", "orange", "black"};
	/**
	 * Constructs a new Goblin with color purple
	 */
	public Goblin() {
		this.color = "purple";
	}


	public String getColor() {
		return color;
	}


	/**
	 * 1) changes the Goblin's color to "red"; 2) decrements the Goblin's health by
	 * 50; 3) returns 50 (the number of strength points awarded to a player for
	 * attacking this Goblin)
	 * 
	 * @return 50 (the number of strength points awarded to a player for attacking
	 *         this Goblin)
	 */
	public int attack() {
		color = "red";
		super.setHealth(this.health -= 50);
		return 50;
	}


	/**
	 * 1) decrements the Goblin's health by 20; 2) changes Goblin's color to the next
	 * one in the cycle purple, orange, black, purple, orange, black, ..., OR if the
	 * Goblin is red (from a stomp), starts the cycle over again with purple
	 */
	public void advanceTime() {
		super.setHealth(this.health -= 20);
		switch (this.color) {
			case "purple":
				this.color = "orange";
				break;
			case "orange":
				this.color = "black";
				break;
			case "black":
            case "red":
                this.color = "purple";
				break;
        }
	}

	public static void main(String[] args) {

	}

}