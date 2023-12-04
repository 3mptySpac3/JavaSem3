/**
 * The Driver class serves as the main entry point for the shape sorting application.
 * 
 * This class provides a user interface to:
 * 1. Choose a file containing shape data.
 * 2. Select a metric (Volume or Base Area) by which the shapes will be sorted.
 * 3. Choose a sorting algorithm to sort the shapes.
 * 
 * After sorting, the shapes are displayed in the sorted order.
 */

package application;
import shape.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.io.File;


public class Driver {
	public static void main(String[]args) throws Exception  {
		Scanner scanner = new Scanner(System.in);
		
		// Ask for file Choice
		System.out.println("Which file do you want to sort? ");
		System.out.println("1. polyfor1.txt");
		System.out.println("2. polyfor3.txt"); 
		System.out.println("3. polyfor5.txt\n");
		int fileChoice = scanner.nextInt();
		
		// Get the filename
		String filename = "";
		switch (fileChoice) {
			case 1: 
				filename = "resources/polyfor1.txt";
				break;
			case 2:
				filename = "resources/polyfor3.txt";
				break;
			case 3:
				filename = "resources/polyfor5.txt";
				break;
			default:
				System.out.println("Wrong choice");
				return;
		}
		
		// Metric wanted to be sorted
		System.out.println("By which metric do you want to sort?");
		System.out.println("1. Volume");
		System.out.println("2. Base Area\n");
		int metricChoice = scanner.nextInt();

		Comparator<Shape> comparator;
		switch (metricChoice) {
		    case 1:
		        comparator = Comparator.comparingDouble(Shape::getVolume);
		        break;
		    case 2:
		        comparator = Comparator.comparingDouble(Shape::getBaseArea);
		        break;
		    default:
		        System.out.println("Invalid metric choice!");
		        return;
		}

        // Parse the selected file to retrieve shape data
		// Read file content & Parse
		List<Shape> shapes = parseShapesFromFile(filename);
		
		System.out.println("Which sorting method do you want to use:");
		System.out.println("1. Bubble Sort");
		System.out.println("2. Insertion Sort");
		System.out.println("3. Selection Sort");
		System.out.println("4. Merge Sort");
		System.out.println("5. Quick Sort");
		System.out.println("6. Bucket Sort \n");
		

		// Convert the List of shapes into an array for easier manipulation with sorting algorithms.
		//This line of code is converting the List<Shape> named shapes into an array of Shape objects. 
		Shape[] shapesArray = shapes.toArray(new Shape[0]);
//		
//		// Print the shapes before sorting
//		System.out.println("Shapes before sorting:");
//		for (Shape shape : shapesArray) { 
//		    System.out.println(shape);
//		}
		
//		Comparator<Shape> byVolume = Comparator.comparingDouble(Shape::getVolume);
//		Comparator<Shape> comparator;
		
		// Read the user's choice for the sorting method from the console input.
		int sortChoice = scanner.nextInt();
		
		//Start time for benchmarking
		
		long startTime = System.nanoTime();
		
		
        // Display shapes before sorting
		System.out.println("Shapes before sorting:");
		for (Shape shape : shapesArray) {
			System.out.println(shape);
		}
		
        // Sort shapes based on user's choice and display them
		switch (sortChoice) {
			case 1:
				//System.out.println("Congratulations! You are using:\n BubbleSort");
				shapesArray = SortUtilitys.bubbleSort(shapesArray, comparator);
				System.out.println("Congratulations! You are using:\n BubbleSort");
//				SortUtilitys.bubbleSort(shapesArray, byVolume);
				break;
			case 2:
				//System.out.println("Congratulations! You are using:\n InsertionSort");
				shapesArray = SortUtilitys.insertionSort(shapesArray, comparator);
				System.out.println("Congratulations! You are using:\n InsertionSort");
				break;
			case 3:
				//System.out.println("Congratulations! You are using:\n SelectionSort");
				shapesArray = SortUtilitys.selectionSort(shapesArray, comparator);
				System.out.println("Congratulations! You are using:\n SelectionSort");
				break;
			case 4:
				//System.out.println("Congratulations! You are using:\n MergeSort");
				shapesArray = SortUtilitys.mergeSort(shapesArray, comparator);
				System.out.println("Congratulations! You are using:\n MergeSort");
				break;
			case 5:
				//System.out.println("Congratulations! You are using:\n QuickSort");
				int high = shapesArray.length - 1;
				SortUtilitys.quickSort(shapesArray, 0, high, comparator);
				System.out.println("Congratulations! You are using:\n QuickSort");
				break;
			case 6:
				//System.out.println("Congratulations! You are using:\n BucketSort");
				shapesArray = SortUtilitys.bucketSort(shapesArray);
				System.out.println("Congratulations! You are using:\n BucketSort");
				break;
			default:
				System.out.println("Invalid sorting choice!");
				return;
		}
		
		// End time for benchmarking
        long endTime = System.nanoTime();

        // Calculate duration
        long duration = endTime - startTime;

        // Display the duration of sorting
        System.out.println("Sorting duration: " + duration + " nanoseconds");
        
     // Display sorted shapes in an array
        for (int i = 0; i < shapesArray.length; i++) {
            if (i == 0 || i == shapesArray.length - 1 || i % 1000 == 0) {
                System.out.println("Shape at index " + i + ": " + shapesArray[i]);
            }
        }
        
//        // Display sorted shapes in an array
//		for (Shape shape : shapesArray) { 
//			System.out.println(shape);
//		}
	}
	
	 /**
     * Parses a file to retrieve shape data and returns a list of shapes.
     * 
     * @param filename The name of the file to be parsed.
     * @return A list of shapes parsed from the file.
     * @throws Exception If there's an error reading the file.
     */
	private static List<Shape> parseShapesFromFile(String filename) throws Exception{
		File file = new File(filename);
		
	    if (!file.exists() || !file.isFile()) {
	        System.out.println("File does not exist or is not a file: " + file.getPath());
	        return new ArrayList<>();  // Return an empty list
	    }
	    
	    Scanner scanner = new Scanner(file);
	    List<Shape> shapes = new ArrayList<>();
	    
	    if (!scanner.hasNext()) {
	    	System.out.println("File format is incorrect. Expected an Int at the start.");
	    	return  shapes;
	    }
	    
	    
//		Scanner scanner = new Scanner(Driver.class.getResourceAsStream("/" + filename));
//		List<Shape> shapes = new ArrayList<>();
		
	    // Read the number of shapes from the file.
		int numberOfShapes = scanner.nextInt();
		
		
		// Loop through each shape entry in the file.
		for (int i = 0; i < numberOfShapes; i++) {
		    // Check if there's more data to read. If not, exit the loop.
			if (!scanner.hasNext()) {
				break; //Exit if no more data
			}
			
		    // Read the shape type and its dimensions from the file.
			String type = scanner.next();
			double dimension1 = scanner.nextDouble();
			double dimension2 = scanner.nextDouble();
			
		    // Based on the shape type, create the appropriate shape object and add it to the shapes list.
			switch (type) {
				case "Cone":
					shapes.add(new Cone(dimension1, dimension2));
					break;
				case "Cylinder":
					shapes.add(new Cylinder(dimension1, dimension2));
					break;
				case "OctagonPrism":
					shapes.add(new OctagonPrism(dimension1, dimension2));
					break;
				case "PentagonPrism":
					shapes.add(new PentagonPrism(dimension1, dimension2));
					break;
				case "Pyramid":
					shapes.add(new Pyramid(dimension1, dimension2 ));
					break;
				case "SquarePrism":
					shapes.add(new SquarePrism(dimension1, dimension2));
					break;
				case "TrianglePrism":
					shapes.add(new TrianglePrism(dimension1, dimension2)); 
					break;
//				 case "OctagonPrism":
//		         case "PentagonPrism":
//		         case "Pyramid":
//		         case "SquarePrism":
//		         case "TrianglePrism":
		        	 
//		     double dimension3 = scanner.nextDouble();
//		     switch (type) {
		     
				
//			}
//		     break;
		     
		     
			}
			
		}
		
		// Close the scanner to release the resources.
		scanner.close();
		
		// Return the list of shapes parsed from the file.
		return shapes;
		

	}
}