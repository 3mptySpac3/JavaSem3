/**
 * The Cylinder class represents a 3D cylindrical shape. It extends the abstract Shape class.
 * 
 * Attributes:
 * - radius: Represents the radius of the base of the cylinder.
 * 
 * Constructors:
 * - Cylinder(double height, double radius): Initializes a new Cylinder object with the specified height and radius.
 * 
 * Methods:
 * - getBaseArea(): Returns the area of the base of the cylinder.
 * - getVolume(): Returns the volume of the cylinder.
 * - toString(): Returns a string representation of the cylinder, including its height, volume, and base area.
 * 
 * The class overrides the getBaseArea() and getVolume() methods from the Shape class to provide the specific
 * calculations for a cylinder.
 */

package shape;


public class Cylinder extends Shape{
	private double radius;
	
	public Cylinder(double height, double radius) {
		super(height);
		this.radius = radius;
	}
	
	// getters and setters 
	
	public double getBaseArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	public double getVolume() {
		return getBaseArea() * getHeight();
	}
	
	@Override
	public String toString() {
	    return "Cylinder [Height=" + getHeight() + ", Volume=" + getVolume() + ", Base Area=" + getBaseArea() + "]";
	}
	
}