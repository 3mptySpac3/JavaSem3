import java.util.ArrayList;
import java.util.*;


public class Driver {
	public static void main(String[]args) {
		
				
		Student student1 = new Student("John", 20);
		Student student2 = new Student("Kevin", 25);
		
		//Using comareTo method
		int comparison = student1.compareTo(student2);
		
		if (comparison < 0) {
			System.out.println(student1.getName() + " is younger than " + student2.getName());
		}
		else if (comparison > 0) {
			System.out.println(student1.getName() + " is older than " + student2.getName());
		}
		else {
			System.out.println(student1.getName() + " and " + student2.getName() + "are the same age. ");
		}
		
		// A list of students
		List<Student> students = new ArrayList<>();
		students.add(student1);
		students.add(student2);
		students.add(new Student("Jacob", 35));
		students.add(new Student("Mark", 13));
		students.add(new Student("Jean", 55));
		students.add(new Student("Rob", 11));
		students.add(new Student("Zuko", 35));




		//Using Comparable to sort and display by name
		Collections.sort(students);
		System.out.println("\nSorted by name then age:");
		for (Student student: students) {
			System.out.println(student.getName() + ", " + student.getAge());
		}
		
		//This is who i am trying to get
		String targetName = "Jean";
		
		int resultIndex =  BiSearch.binarySearch(students, targetName);
		if(resultIndex!=-1) {
			System.out.println("Student " + targetName + " found at index " + resultIndex);
		}else {
			System.out.println("Student " + targetName + " not found in index you dum dum.");
		}
		
		//Using Comparator to sort and display by age, then name
		Collections.sort(students, new AgeCompare());
		System.out.println("\nSorted by age, then name:");
		for (Student student : students) {
			System.out.println(student.getAge() + ", " + student.getName());
		}
		
		Scanner myscanner = new Scanner(System.in);
		int[] array = {43, 15, 62, 18, 94, 31, 87, 12, 76, 2, 5, 8, 17, 1, 3, 4};
		
		System.out.println("Original Array: " + Arrays.toString(array));
        System.out.println("Choose a sorting algorithm:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Insertion Sort");
        System.out.println("3. Selection Sort");
        System.out.println("4. Quick Sort");
        System.out.print("Enter choice (1-4): ");
        
        int choice = myscanner.nextInt();
        switch(choice) {
        case 1:
        	SortingAlgo.bubbleSort(array);
        	System.out.println("Using Bubble Sort");
        	break;
        case 2:
        	SortingAlgo.insertionSort(array);
        	System.out.println("Using Insertion Sort");
        	break;
        case 3:
        	SortingAlgo.selectionSort(array);
        	System.out.println("Using Selection Sort");
        	break;
        case 4:
        	SortingAlgo.quickSort(array,0, array.length - 1);
        	System.out.println("Using Quick Sort");
        	break;
        	
        default:
        	System.out.println("Invalid Choice. Exiting.");
            System.exit(1);
        	
        	
        }
        System.out.println("Sorted Array: " + Arrays.toString(array));

		
	}
}
