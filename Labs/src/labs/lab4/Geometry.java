package labs.lab4;
import java.lang.Math;


/**
 * A class that can calculate surface area and volume of cubes, rectangular
 * prisms,and square pyramids. 
 */
public class Geometry {

	/**
	 * Calculates the volume of a cube.
	 * 
	 * @param 	sideLength	the length of one side of the cube (assume > 0)
	 * @return 	the volume of the cube
	 */
	public static double cubeVolume(double sideLength) {
		return Math.pow(sideLength, 3);
	}


	/**
	 * Calculates the surface area of a cube.
	 * 
	 * @param 	sideLength	the length of one side of the cube (assume > 0)
	 * @return 	the surface area of the cube
	 */
	public static double cubeSurface(double sideLength) {
		return Math.pow(sideLength, 2) * 6;
	}


	/**
	 * Calculates the volume of a rectangular prism.
	 * 
	 * @param 	width		the width of the prism's base (assume > 0)
	 * @param 	length	the length of the prism's base (assume > 0)
	 * @param 	height	the height of the prism (assume > 0)
	 * @return 	the volume of the rectangular prism
	 */
	public static double prismVolume(double width, double length, double height) {
		return width * length * height;
	}
	
	
	/**
	 * Calculates the surface area of a rectangular prism.
	 * 
	 * @param 	width		the width of the prism's base (assume > 0)
	 * @param 	length	the length of the prism's base (assume > 0)
	 * @param 	height	the height of the prism (assume > 0)
	 * @return 	the surface area of the rectangular prism
	 */
	public static double prismSurface(double width, double length, double height) {
		return 2 * (width * length + height * length + height * width);
	}
	
	
	/**
	 * Calculates the volume of a right square pyramid.
	 * 
	 * @param 	edgeLength		the length of one of the pyramid's base edges (assume > 0)
	 * @param 	height			the height of the pyramid (assume > 0)
	 * @return 	the volume of the pyramid
	 */
	public static double pyramidVolume(double edgeLength, double height) {
		return Math.pow(edgeLength, 2) * (height / 3);
	}
	
	
	/**
	 * Calculates the surface area of a right square pyramid.
	 * 
	 * @param 	edgeLength		the length of one of the pyramid's base edges (assume > 0)
	 * @param 	height			the height of the pyramid (assume > 0)
	 * @return 	the surface area of the pyramid
	 */
	public static double pyramidSurface(double edgeLength, double height) {
		return Math.pow(edgeLength, 2) + 2 * edgeLength * Math.sqrt(Math.pow(edgeLength, 2) / 4 + Math.pow(height, 2));
	}
}
