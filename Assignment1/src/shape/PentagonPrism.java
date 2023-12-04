/**
 * Represents a Pentagon Prism shape.
 * 
 * The PentagonPrism class extends the Prism class and provides the implementation
 * for calculating the base area of a pentagonal prism. The base area is calculated
 * using the formula: (5 * side^2 * tan(54 degrees)) / 4, where 'side' is the length 
 * of one side of the pentagon.
 * 
 * The volume of the pentagonal prism can be derived from the Prism class by multiplying
 * the base area with the height of the prism.
 * 
 * The toString method provides a string representation of the pentagonal prism, displaying
 * its height, volume, and base area.
 */

package shape;

public class PentagonPrism extends Prism{
	public PentagonPrism(double height, double side) {
		super(height, side);
	}
	
	public double getBaseArea() {
		return (5 * Math.pow(getSide(), 2) * Math.tan(Math.toRadians(54))) / 4;
	}
	
	@Override
	public String toString() {
	    return "PentagonPrism [Height=" + getHeight() + ", Volume=" + getVolume() + ", Base Area=" + getBaseArea() + "]";
	}


}
