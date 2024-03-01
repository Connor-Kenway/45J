package labs.lab4;

import static labs.lab4.Geometry.pyramidSurface;
import static labs.lab4.Geometry.pyramidVolume;

/**
 * A class that represents a right square pyramid and can calculate its volume and surface
 * area.
 */
public class Pyramid {

	 // ADD YOUR INSTANCE VARIABLES HERE
	 double edgeLength;
	 double height;

	/**
	 * Creates a new right square pyramid of given edge length and height.
	 * 
	 * @param 	edgeLength		the length of one of the pyramid's base edges (assume > 0)
	 * @param 	height			the height of the pyramid (assume > 0)
	 */
	public Pyramid(double edgeLength, double height) {
		this.edgeLength = edgeLength;
		this.height = height;
	}


	/**
	 * Calculates the volume of the pyramid.
	 * 
	 * @return the volume of the pyramid
	 */
	public double getVolume() {
		return pyramidVolume(edgeLength, height);
	}


	/**
	 * Calculates the surface area of the pyramid.
	 * 
	 * @return the surface area of the pyramid
	 */
	public double getSurface() {
		return pyramidSurface(edgeLength, height);
	}
}
