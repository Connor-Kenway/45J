package labs.lab1;

/**
 * Compute international standard sizes for paper, where A0 = 841 x 1189 mm A1 =
 * 594 x 841 mm A2 = 420 x 594 mm A3 = 292 x 423 mm etc
 */
public class Sheet {

	// ADD YOUR INSTANCE VARIABLES HERE
	private String name;
	private int type, width, length;
	
	/**
	 * create a sheet of size A0
	 */
	public Sheet() {
		type = 0;
		name = "A" + type;
		width = 841;
		length = 1189;
	}

	
	/**
	 * @return the width of the paper
	 */
	public int getWidth() { return width; }

	
	/**
	 * @return the length of the paper
	 */
	public int getLength() { return length; }

	
	/**
	 * @return the ISO name for the paper
	 */
	public String getName() { return name; }

	
	/**
	 *
	 * @return a sheet that is cut in half along the length
	 */
	public Sheet cutInHalf() {
		int oldWidth, oldLength;
		oldWidth = width;
		oldLength = length;
		this.type = type + 1;
		this.name = "A" + type;
		this.width = oldLength/2;
		this.length = oldWidth;
		return this;
	}
}
