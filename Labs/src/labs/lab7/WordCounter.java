package labs.lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * A program that reads text from a file and breaks it up into individual words,
 * inserts the words into a tree set, and allows you to get stats about the
 * words.
 */
public class WordCounter {
	private TreeSet<String> uniqueWords;
	private int totalWords;

	/**
	 * Constructor
	 * 
	 * @param filename file from which to read words
	 */
	public WordCounter(String filename) {
		uniqueWords = new TreeSet<>();
		totalWords = 0;
		readFile(filename);
	}

	private void readFile(String filename) {
		try (Scanner scanner = new Scanner(new File(filename))) {
			while (scanner.hasNext()) {
				String word = scanner.next().toLowerCase(); // Convert to lowercase
				word = word.replaceAll("[^a-z0-9]", ""); // Remove non-letter and non-digit characters
				if (!word.isEmpty()) { // Check if the word is not empty after cleanup
					uniqueWords.add(word);
					totalWords++;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File: " + filename + " not found");
		}
	}

	/**
	 * Returns the number of unique words in the file
	 * 
	 * @return number of unique words
	 */
	public int getNumUniqueWords() {
		return uniqueWords.size();
	}


	/**
	 * Returns the number of words in the file
	 * 
	 * @return number of words
	 */
	public int getNumWords() {
		return totalWords;
	}


	/**
	 * returns a list of the unique words with all non-letter and non-digit
	 * characters removed, all in lower case, as a List in alphabetical order
	 * 
	 * @return list of unique words
	 */
	public List<String> getUniqueWords() {
		return new ArrayList<>(uniqueWords);
	}
}
