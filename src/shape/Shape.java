/**
 * The Shape class is an abstract representation of a 3D shape.
 * 
 * This class provides the foundational structure for any 3D shape, 
 * capturing common properties like height and defining abstract methods 
 * for volume and base area, which must be implemented by any concrete subclass.
 * 
 * The class also implements the Comparable interface, allowing shapes to be 
 * compared based on their volume and, if volumes are equal, their height.
 */

package shape;

public abstract class Shape implements Comparable<Shape>{
	
	private double height;
	
    // Constructor to initialize the height of the shape
	public Shape(double height) {

		this.height = height;
	}
	
    // Getter method to retrieve the height of the shape
	//Operational Methods
	// Getter/ Accessory 
	public double getHeight() {
		return height;
	}
	
    // Setter method to set the height of the shape
	// Setter/ Accessory
	public void setHeight(double height) {
		this.height = height;
	}
	
	
    // Abstract method to calculate the volume of the shape
	public abstract double getVolume();
	

    // Abstract method to calculate the base area of the shape
	public abstract double getBaseArea();
	
	
    // Compares shapes based on their volume and, if equal, their height
	@Override
	public int compareTo(Shape that) {
	    int volumeComparison = Double.compare(this.getVolume(), that.getVolume());
	    
	    if (volumeComparison != 0) {
	        return volumeComparison;
	    }
	    
	    // If volumes are equal, compare by height
	    if (this.height < that.height) {
	        return -1;
	    }
	    if (this.height > that.height) {
	        return 1;
	    }
	    
	    return 0;
	}
	




    // Provides a string representation of the shape's properties
	@Override
	public String toString() {
		return "Shape [getHeight()=" + getHeight() + ", getVolume()=" + getVolume() + ", getBaseArea()=" + getBaseArea()
				+ "]";
	}
	
	
}
