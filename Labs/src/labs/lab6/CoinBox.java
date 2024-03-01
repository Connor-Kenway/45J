package labs.lab6;

/**
 * A box of coins.
 */
public class CoinBox {

	// ADD YOUR INSTANCE VARIABLES HERE
	double coins;

	/**
	 * Constructs an empty CoinBox object.
	 */
	public CoinBox() {
		coins = 0.0;
	}


	/**
	 * Adds a coin.
	 * 
	 * @param c the coin to add
	 */
	public void addCoin(Coin c) {
		coins += c.getValue();
	}


	/**
	 * Removes coins from another coinbox and adds them to this one. 
	 * 
	 * @param other the box of coins from which to add
	 */
	public void addCoins(CoinBox other) {
		this.coins += other.coins;
		other.coins = 0.0;
	}


	/**
	 * Gets the value of all the coins.
	 * 
	 * @return total the total value of all the coins
	 */
	public double getValue() {
		return coins;
	}


	/**
	 * Removes all the coins.
	 */
	public void removeAllCoins() {
		coins = 0.0;
	}

}