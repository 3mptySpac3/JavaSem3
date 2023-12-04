/**
 * The Prism class represents a geometric prism shape. A prism is a polyhedron 
 * with two parallel and congruent faces (known as the bases) and whose 
 * remaining faces (known as the lateral faces) are parallelograms.
 * 
 * This class is abstract, meaning it cannot be instantiated directly. 
 * Instead, it serves as a base class for other specific types of prisms 
 * (e.g., PentagonPrism, OctagonPrism). 
 * 
 * The Prism class extends the Shape class and provides a common structure 
 * for prisms, including a side attribute which represents the length of a 
 * side of the base of the prism. The class also provides a method to 
 * calculate the volume of the prism and an abstract method to calculate 
 * the area of the base, which must be implemented by subclasses.
 */

package shape;

public abstract class Prism extends Shape{
	
	//attributes
	private double side;
	
	public Prism(double height, double side) {
		super(height);
		this.side = side;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}
	
	@Override
	public double getVolume() {
		return getBaseArea() * getHeight();
	}
	
	public abstract double getBaseArea();
	

}