##################################################
## Assignment: Complexity and Sorting
##################################################

# Overview:
-----------
The Geometric Shape Sorting Application is a Java program that specializes in reading and sorting three-dimensional geometric shapes based on specific characteristics. It offers a user-friendly interface for:

1. Selecting a file containing shape data.
2. Choosing a metric (Volume or Base Area) for sorting shapes.
3. Picking a sorting algorithm.

Post-sorting, the application showcases the shapes in the sorted sequence.

# Table of Contents:
--------------------
- Specifications of the Application
- How to Use
- Structure of the Project
- Documentation Details
- List of Contributors

# Specifications of the Application:
------------------------------------
The Geometric Shape Sorting Application boasts the following features:

1. Utilizes an abstract class 'Shape' to depict three-dimensional geometric shapes. Implements Comparable and Comparator interfaces for sorting by height, volume, and base area.

2. Capable of reading and interpreting shape data from text files. Offers a choice among three files:
   - polyfor1.txt
   - polyfor3.txt
   - polyfor5.txt
   Users have the liberty to choose their preferred file.

3. Sorting criteria options provided to users:
   - Sort by Volume
   - Sort by Base Area

4. Supports a variety of sorting algorithms:
   - Bubble Sort
   - Insertion Sort
   - Selection Sort
   - Merge Sort
   - Quick Sort
   - Bucket Sort

5. Benchmarks the chosen sorting algorithm and displays the sorting duration.

6. Exhibits the first sorted value, the last one, and every thousandth value in the sequence.

7. All sorting algorithms are encapsulated in a utility class for enhanced reusability.

# How to Use:
-------------
Follow these steps to run the application:

1. Open the project in a JavaSE-1.8 compatible IDE, like Eclipse.

2. Find and execute the 'Driver' class, the application's starting point.

3. The application will prompt you to select a shape data file, a sorting metric, and an algorithm.

4. Witness the display of sorted shapes as per your selections.

# Structure of the Project:
---------------------------
Key components of the project include:

- 'application' package: Houses the 'Driver' main class for application execution and user interaction.

- 'shape' package: Contains diverse shape classes such as 'Cone,' 'Cylinder,' 'OctagonPrism,' 'PentagonPrism,' 'Pyramid,' 'SquarePrism,' and 'TrianglePrism.' These extend the 'Shape' abstract class and implement specific volume and base area calculations.

- 'SortUtilitys' class: Offers a suite of sorting algorithms like Bubble Sort, Insertion Sort, Selection Sort, Merge Sort, Quick Sort, and Bucket Sort for shape sorting.

# Documentation Details:
-------------------------
The code is well-documented with comments that elucidate the purpose and functionality of classes and methods. For in-depth understanding, refer to these comments.

# List of Contributors:
-----------------------
- Jean-Pierre
- Valentine
- Martin
- Isabelle
