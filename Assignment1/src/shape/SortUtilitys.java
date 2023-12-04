package shape;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class SortUtilitys {

    // Bubble Sort
	//Repeatedly steps through the list, compares adjacent elements, 
	//and swaps them if they are in the wrong order. The pass through 
	//the list is repeated until the list is sorted.
	
    public static Shape[] bubbleSort(Shape[] array, Comparator<Shape> comparator) {
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    Shape temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    
                    
                }
            }
        }
//        System.out.println("Sorted shapes: ");
//        for (Shape shape : array) {
//        	System.out.println(shape);
//        }
        	return array;
    }
    
    // Insertion Sort
    //Builds the final sorted list one item at a time. It takes one element 
    //from the input data in each iteration and finds its correct position 
    //in the sorted list, moving the larger values up to make space.
    
    public static Shape[] insertionSort(Shape[] array, Comparator<Shape> comparator) {
    	int n = array.length;
    	for (int i = 1; i < n; ++i) {
    		Shape key = array[i];
    		int j = i - 1;
    		
    		while (j >= 0 && comparator.compare(array[j], key) > 0) {
    			array[j + 1] = array[j];
    			j = j - 1;
    		}
    		array[j + 1] = key;
    	}
    	return array;
    	
    }
    
    // Selection Sort 
    //Repeatedly selects the smallest (or largest) element from the unsorted 
    //portion of the list and swaps it with the first unsorted element, moving
    //it to the sorted portion of the list.
    
    public static Shape[] selectionSort(Shape[] array, Comparator<Shape> comparator) {
    	int n = array.length;
    	for (int i = 0; i < n-1; i++) {
    		int min_index = i;
    		for (int j = i+1; j < n; j++) {
    			if (comparator.compare(array[j], array[min_index]) < 0) {
    				min_index = j;
    			}
    		}
    		if (min_index !=i) {
    			Shape temp = array[min_index];
    			array[min_index] = array[i];
    			array[i] = temp;
    		}
    	}
    	return array;
    }
    
    // Merge Sort
    //Divides the unsorted list into n sublists (each containing one element), 
    //then repeatedly merges these sublists to produce new sorted 
    //sublists until only one remains.
    
    public static Shape[] mergeSort(Shape[] array, Comparator<Shape> comparator) {
        if (array.length < 2) {
            return array;  // If the array has less than 2 elements, it's already sorted.
        }
        
        int mid = array.length / 2;
        Shape[] left = new Shape[mid];
        Shape[] right = new Shape[array.length - mid];
        
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);
        
        mergeSort(left, comparator);
        mergeSort(right, comparator);
        
        merge(array, left, right, comparator);
        
        return array;
    }

    
    private static void merge(Shape[] array, Shape[] left, Shape[] right, Comparator<Shape> comparator) {
    	int i = 0, j = 0, k = 0;
    	
    	while (i < left.length && j < right.length) {
    		if (comparator.compare(left[i], right[j])<= 0) {
    			array[k++] = left[i++];
    		}else {
    			array[k++] = right[j++];
    		}
    	}
    	while (i < left.length) {
    		array[k++] = left[i++];
    	}
    	while (j < right.length) {
    		array[k++] = right[j++];
    	}
    }
    
    // Quick Sort 
    //Selects a 'pivot' element from the list and partitions the other elements into 
    //two sub-arrays, according to whether they are less than or greater than the pivot.
    //The sub-arrays are then sorted recursively.
    
    public static Shape[] quickSort(Shape[] array, int low, int high, Comparator<Shape> comparator) {
    	if (low < high) {
    		int pi = partition(array, low, high, comparator);
    		quickSort(array, low, pi - 1, comparator);
    		quickSort(array, pi + 1, high, comparator);
    	}
    	return array;
    }
    
    private static int partition(Shape[] array, int low, int high, Comparator<Shape> comparator) {
    	Shape pivot = array[high];
    	int i = (low -1);
    	for (int j = low; j < high; j++) {
    		if (comparator.compare(array[j], pivot) <= 0) {
    			i++;
    			Shape temp = array[i];
    			array[i] = array[j];
    			array[j] = temp;
    			
    		}
    	}
    	
    	Shape temp = array[i + 1];
    	array[i + 1] = array[high];
    	array[high] = temp;
    	
    	return i + 1;
    	
    }
    
    //Bucket Sort
    //In simple terms, Bucket Sort breaks the data into smaller, 
    //more manageable groups (or "buckets") and sorts each group 
    //before combining them for the final sorted result.
    
    public static Shape[] bucketSort(Shape[] shapes) {
    	final int numberOfBuckets = (int) Math.sqrt(shapes.length);
    	List<List<Shape>> buckets = new ArrayList<>(numberOfBuckets);
    	
    	
    	for (int i = 0; i < numberOfBuckets; i++) {
    		buckets.add(new ArrayList<>());
    	}
        // Calculate the maximum volume to know the range of data
    	double maxVolume = Double.MIN_VALUE;
    	for (Shape shape : shapes) {
    		if (shape.getVolume() > maxVolume) {
    			maxVolume = shape.getVolume();
    		}
    		
    	}
        // Add shapes to their respective buckets
    	for (Shape shape : shapes) {
    		int bucketIndex = (int) (shape.getVolume() * numberOfBuckets / (maxVolume + 1));
    		buckets.get(bucketIndex).add(shape);
    	}
        // Sort each bucket individually and gather them back into the original array
    	int index = 0;
    	for (List<Shape> bucket : buckets) {
    		Collections.sort(bucket, (s1, s2) -> Double.compare(s1.getVolume(), s2.getVolume()));
    		for (Shape shape : bucket) {
    			shapes[index++] = shape;
    		}
    	}
    	return shapes;
    	
    }
    
    
}
