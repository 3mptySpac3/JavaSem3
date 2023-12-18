package utilities;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordTracker {

	private List<String> foundWords;
	
    private BSTree<Word> wordTree;
    private static final String REPOSITORY_FILE = "repository.ser";


    public WordTracker() {
        this.wordTree = new BSTree<>();
        this.foundWords = new ArrayList<>(); // Initialize foundWords
        // Initialize the wordTree and populate it as needed
    }

        // Initialize the wordTree and populate it as needed
    
    


    public void processFile(String filename) throws IOException, TreeException {
        Path file = Paths.get(filename);
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++; // Increment line number
                String[] words = line.toLowerCase().split("\\W+");

                for (String wordStr : words) {
                    if (!wordStr.trim().isEmpty()) {
                        Word word = new Word(wordStr); // Create a new Word object
                        // Check if the word is already in the BST
                        if (wordTree.contains(word)) {
                            // If it is, retrieve it and update its occurrences
                            word = wordTree.search(word).getData();
                        } else {
                            wordTree.add(word);
                        }
                        word.addOccurrence(filename, lineNumber); // Add occurrence
                    }
                }
            }
        }
        // Serialize the tree after processing the file
        saveRepository();
        
        System.out.println("Done processing!");

    }


    @SuppressWarnings("unchecked")
    private void loadRepository() {
        File file = new File(REPOSITORY_FILE);

        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                // Cast is needed because readObject() returns Object
                Object object = ois.readObject();
                if (object instanceof BSTree) {
                    wordTree = (BSTree<Word>) object; // Assign the loaded tree to wordTree
                } else {
                    throw new ClassNotFoundException("The object read is not an instance of BSTree");
                }
            } catch (IOException e) {
                System.err.println("Unable to read the repository file. A new tree will be created.");
            } catch (ClassNotFoundException e) {
                System.err.println("Class not found on deserialization: " + e.getMessage());
            }
        }
    }

    private void saveRepository() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(REPOSITORY_FILE))) {
            oos.writeObject(wordTree);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error saving repository: " + e.getMessage());
        }
    }
    
    
    private void printFoundWords() {
        if (!foundWords.isEmpty()) {
            System.out.println("Words found in the search:");
            for (String word : foundWords) {
                System.out.println(word);
            }
        } else {
            System.out.println("No words were found during the search.");
        }
    }


    public static void main(String[] args) throws IOException, TreeException {
        // Instantiate the WordTracker
        WordTracker wordTracker = new WordTracker();

        // Load the repository if it exists, otherwise, load the file to populate the tree
        try {
            wordTracker.loadRepository();
            if (wordTracker.isTreeEmpty()) {
                // The fixed filename from which to read the 
                String filename = "src/utilities/textfile.txt";
                wordTracker.processFile(filename);  // Populate the tree
            }
        } catch (IOException | TreeException e) {
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        // Initialize the scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Enter the search loop
        System.out.println("Enter a word to search for (or type 'exit' to quit):");
        String searchWord;
        while (!(searchWord = scanner.nextLine()).equalsIgnoreCase("exit")) {
            wordTracker.searchAndDisplay(searchWord); // Search for the word and display results
            wordTracker.addToFoundWords(searchWord); // Store found words
            System.out.println("Enter another word (or type 'exit' to quit):");
        }

        // Save the current state of the tree, if necessary
        try {
            wordTracker.saveRepository();
        } finally {
            scanner.close();
        }
        
        wordTracker.printFoundWords();

        // Save the current state of the tree, if necessary
        try {
            wordTracker.saveRepository();
        } finally {
            scanner.close();
        }
    }
    
    private void addToFoundWords(String word) {
        foundWords.add(word);
    }


    private void searchAndDisplay(String searchWord) throws TreeException {
        // Assuming you have a method in BSTree that returns a BSTreeNode<Word> with the search result
        BSTreeNode<Word> wordNode = wordTree.search(new Word(searchWord));
        if (wordNode != null) {
            // Extract the Word object from the BSTreeNode
            Word word = wordNode.getData();
            
            // Display the word, the files, and the line numbers
            System.out.println("Word found: " + word.getWord());
            List<String> fileNames = word.getFileNames();
            List<Integer> lineNumbers = word.getLineNumbers();
            
            for (int i = 0; i < fileNames.size(); i++) {
                System.out.println("File: " + fileNames.get(i) + ", Line: " + lineNumbers.get(i));
            }
        } else {
            System.out.println("Word not found.");
        }
    }




	private boolean isTreeEmpty() {
		// TODO Auto-generated method stub
	    return wordTree.isEmpty();
	}



	public void printWordsAndFiles(PrintStream output) {
        // Assuming that the inorderIterator() method is properly implemented in BSTree
        Iterator<Word> iterator = wordTree.inorderIterator();
        while (iterator.hasNext()) {
            Word word = iterator.next();
            output.print(word.getWord() + ": ");
            for (String fileName : word.getFileNames()) {
                output.print(fileName + " ");
            }
            output.println(); // End the line after printing all file names for a word
        }
        
        
    }
	
	

}
