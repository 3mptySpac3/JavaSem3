import java.util.Arrays;

public class SortingAlgo {

	//Bubble Sort
	public static void bubbleSort(int[]array) {
		int n = array.length;
		for (int i = 0; i < n-1; i++)
			for (int j = 0; j < n-i-1; j++)
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
	}
	
	//Insertion Sort
	public static void insertionSort(int[]array) {
		for (int i = 1; i <array.length; ++i) {
			int key = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j +1] = key;
		}
	}
	
	//Selection Sort
	public static void selectionSort(int[]array) {
		int n = array.length;
		for (int i = 0; i < n-1; i++) {
			int min_index = i;
			for (int j = i+1; j < n; j++)
				if (array[j] < array[min_index])
					min_index = j;
			
			int temp = array[min_index];
			array[min_index] = array[i];
			array[i] = temp;
		}
	}
	
	//Quick Sort
	public static void quickSort(int[]array, int low, int high) {
		if (low < high) {
			int pi = partition(array, low, high);
			quickSort(array, low, pi-1);
			quickSort(array, pi+1, high);
		}
		
	}
	
	private static int partition(int[]array, int low, int high) {
		int pivot = array[high];
		int i = (low-1);
		for (int j=low; j<high; j++) {
			if (array[j] <=pivot) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;
		
		return i + 1;
	}
	
}
