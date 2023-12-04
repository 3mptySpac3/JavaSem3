/**
 * Represents an Octagon Prism shape.
 * 
 * The OctagonPrism class extends the Prism class and provides the implementation
 * for calculating the base area of an octagonal prism. The base area is calculated
 * using the formula: 2 * (1 + sqrt(2)) * side^2, where 'side' is the length of one
 * side of the octagon.
 * 
 * The volume of the octagonal prism can be derived from the Prism class by multiplying
 * the base area with the height of the prism.
 * 
 * The toString method provides a string representation of the octagonal prism, displaying
 * its height, volume, and base area.
 */

package shape;

public class OctagonPrism extends Prism{
	public OctagonPrism(double height, double side) {
		super(height, side);
	}
	
	public double getBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * Math.pow(getSide(), 2);
	}
	
	@Override
	public String toString() {
	    return "OcragonPrism [Height=" + getHeight() + ", Volume=" + getVolume() + ", Base Area=" + getBaseArea() + "]";
	}

}
