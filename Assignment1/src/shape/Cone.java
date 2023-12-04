/**
 * The Cone class represents a 3D cone shape. It extends the abstract Shape class.
 * 
 * Attributes:
 * - radius: Represents the radius of the base of the cone.
 * 
 * Constructors:
 * - Cone(double height, double radius): Initializes a new Cone object with the specified height and radius.
 * 
 * Methods:
 * - getBaseArea(): Returns the area of the base of the cone.
 * - getVolume(): Returns the volume of the cone.
 * - toString(): Returns a string representation of the cone, including its height, volume, and base area.
 * 
 * The class overrides the getBaseArea() and getVolume() methods from the Shape class to provide the specific
 * calculations for a cone.
 */

package shape;

public class Cone extends Shape{
	
	//attributes fields
	private double radius;
	
	public Cone(double height, double radius){
		super(height);
		this.radius = radius;
	}
	
	
	public double getBaseArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	
	public double getVolume() {
		return getBaseArea() * getHeight()/3;
		
	}
	
	@Override
	public String toString() {
	    return "Cone [Height=" + getHeight() + ", Volume=" + getVolume() + ", Base Area=" + getBaseArea() + "]";
	}
	
	
}
