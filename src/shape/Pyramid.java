/**
 * 
 * This class extends the Shape class and provides the structure for a pyramid with a square base.
 * The Pyramid class has attributes for the side length of the base and methods to calculate 
 * the base area and the volume of the pyramid.
 * 
 * The base area is calculated as the square of the side length, and the volume is calculated 
 * as one-third of the product of the base area and the height of the pyramid.
 * 
 * The class also provides a custom toString method to represent the pyramid's properties in a string format.
 */

package shape;

public class Pyramid extends Shape{
	private double side;
	
	public Pyramid(double height, double side) {
		super(height);
		this.side = side;
	}

	
	//getters and setters for side
	
	public double getSide() {
		return side;
	}
	
	public void setSide(double side) {
		this.side = side;
	}
	 
	public double getBaseArea() {
		return Math.pow(side,2);
	}
	
	 
	public double getVolume() {
		return (getBaseArea() * getHeight()) / 3;
	}
	
	@Override
	public String toString() {
	    return "Pyramid [Height=" + getHeight() + ", Volume=" + getVolume() + ", Base Area=" + getBaseArea() + "]";
	}


}
