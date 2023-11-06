/**
 * The SquarePrism class represents a prism with a square base.
 * 
 * This class extends the Prism class and provides the structure for a prism 
 * where the base is a square. The base area is calculated as the square of the side length.
 * 
 * The class also provides a custom toString method to represent the square prism's properties in a string format.
 */

package shape;

public class SquarePrism extends Prism{
	public SquarePrism(double height, double side) {
		super(height, side);
	}
	
	
	public double getBaseArea() {
		return Math.pow(getSide(), 2);
	}
	
	@Override
	public String toString() {
	    return "SquarePrism [Height=" + getHeight() + ", Volume=" + getVolume() + ", Base Area=" + getBaseArea() + "]";
	}

}
