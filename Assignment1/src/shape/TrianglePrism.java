/**
 * The TrianglePrism class represents a prism with an equilateral triangle base.
 * 
 * This class extends the Prism class and provides the structure for a prism 
 * where the base is an equilateral triangle. The base area is calculated using 
 * the formula for the area of an equilateral triangle.
 * 
 * The class also provides a custom toString method to represent the triangle prism's properties in a string format.
 */

package shape;

public class TrianglePrism extends Prism{
	public TrianglePrism(double height, double side) {
		super(height, side);
	}
	
	
	public double getBaseArea() {
		return (Math.pow(getSide(), 2) * Math.sqrt(3))/ 4;
	}
	@Override
	public String toString() {
	    return "TrianglePrism [Height=" + getHeight() + ", Volume=" + getVolume() + ", Base Area=" + getBaseArea() + "]";
	}

}
