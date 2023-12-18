package utilities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Word implements Serializable, Comparable<Word> {
    private static final long serialVersionUID = 1L; // Ensure backward compatibility
    private String word;
    private List<Integer> lineNumbers;
    private List<String> fileNames;

    public Word(String word) {
        this.word = word;
        this.lineNumbers = new ArrayList<>();
        this.fileNames = new ArrayList<>();
    }

    public void addOccurrence(String fileName, int lineNumber) {
        if (!fileNames.contains(fileName)) {
            fileNames.add(fileName);
        }
        lineNumbers.add(lineNumber);
    }

    // Getters, setters, and compareTo method based on word
    // ...

    @Override
    public int compareTo(Word o) {
        return this.word.compareToIgnoreCase(o.word);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Word wordObj = (Word) obj;
        return this.word.equals(wordObj.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }


	
    public List<String> getFileNames() {
        return fileNames;
    }
    
    public List<Integer> getLineNumbers() {
        return lineNumbers;
    }
    
    public int getOccurrencesCount() {
        return lineNumbers.size();
    }

	public String getWord() {
		return word;
	}




    
}
