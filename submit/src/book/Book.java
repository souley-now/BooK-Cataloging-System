package book;

import book.file.BookFileReader;
import java.util.*;

/**
 * Represents a book to be cataloged.
 * @author Souley Diallo
 * 
 */
public class Book {

	/**
	 * Title of book.
	 */
	private String title;
	
	/**
	 * Author of book.
	 */
	private String author;
	
	/**
	 * Lines in book.
	 */
	private List<String> lines;
	
	/**
	 * Count of words in book.
	 */
	private int wordCount;
	
	/**
	 * Count of each word in book.
	 */
	private Map<String, Integer> wordCounts;
	

	public Book(List<String> lines) {
		this.lines = lines;
		this.setTitleAndAuthor();
		this.countWords();
	}
	

//
	private void setTitleAndAuthor() {
		String title = null;
		String author = null;
		for (String line : lines) {
			if (line.startsWith("Title:")) {
				title = line.substring(6).trim();
			} else if (line.startsWith("Author:")) {
				author = line.substring(7).trim();
			}
		}
		this.title = title;
		this.author = author;
	}

	public String getTitle() {
		return this.title;
	}
	public String getAuthor() {
		return this.author;
	}
	private void countWords() {
		this.wordCounts = new TreeMap<>();
		int wordCount = 0;
		for (String line : lines) {
			String[] words = line.split("[^a-zA-Z0-9_%+-]+");
			for (String word : words) {
				word = word.toLowerCase();
				if (word.length() > 0) {
					int count = wordCounts.getOrDefault(word, 0);
					wordCounts.put(word, count + 1);
					wordCount++;
				}
			}
		}
		this.wordCount = wordCount;
	}

	
	/**
	 * Gets total count of all words.
	 * @return count of all words
	 */

	public int getTotalWordCount() {
		return this.wordCount;
	}

	/**
	 * Gets unique count of words.
	 * Does not consider case when counting words.  e.g. "Love" is the same word as "love".
	 * 
	 * Example: "One Two two Three three three" has only 3 unique words.
	 * 
	 * @return count of unique words
	 */
	public int getUniqueWordCount() {
		return this.wordCounts.size();
	}
	
	/**
	 * Gets the count of the given word.
	 * Does not consider case when counting words.  e.g. "Love" is the same word as "love".
	 * Returns 0 if the given word doesn't exist.
	 * 
	 * @param word to count
	 * @return count of given word
	 */
	public int getSpecificWordCount(String word) {
		int count = wordCounts.getOrDefault(word.toLowerCase(), 0);
		return count;
	}
	
	/**
	 * Gets the book lines.
	 * @return lines in book
	 */
	public List<String> getLines() {
		return this.lines;
	}
	
	///// DO NOT CHANGE CODE IN MAIN METHOD! /////
	public static void main(String[] args) {
	    
		//load and parse book files
		List<String> catInTheHat = BookFileReader.parseFile("the_cat_in_the_hat_snippet.txt");
		List<String> warAndPeace = BookFileReader.parseFile("war_and_peace.txt");
		List<String> siddhartha = BookFileReader.parseFile("siddhartha.txt");
		
		//create instances of book with lists above
		Book catInTheHatBook = new Book(catInTheHat);
		Book warAndPeaceBook = new Book(warAndPeace);
		Book siddharthaBook = new Book(siddhartha);
			
		//get lines from books
		System.out.println("\nGET FIRST 3 LINES");
		System.out.println(catInTheHatBook.getLines().subList(0, 3));
		System.out.println(warAndPeaceBook.getLines().subList(0, 3));
		System.out.println(siddharthaBook.getLines().subList(0, 3));
				
		//get titles of books
		System.out.println("\nGET TITLES");
		String catInTheHatBookTitle = catInTheHatBook.getTitle();
		System.out.println(catInTheHatBookTitle);
		String warAndPeaceBookTitle = warAndPeaceBook.getTitle();
		System.out.println(warAndPeaceBookTitle);
		String siddharthaBookTitle = siddharthaBook.getTitle();
		System.out.println(siddharthaBookTitle);
		
		//get authors of books
		System.out.println("\nGET AUTHORS");
		String catInTheHatBookAuthor = catInTheHatBook.getAuthor();
		System.out.println(catInTheHatBookAuthor);
		String warAndPeaceBookAuthor = warAndPeaceBook.getAuthor();
		System.out.println(warAndPeaceBookAuthor);
		String siddharthaBookAuthor = siddharthaBook.getAuthor();
		System.out.println(siddharthaBookAuthor);
		
		//get total word counts from books
		System.out.println("\nGET TOTAL WORD COUNTS");
		System.out.println(catInTheHatBook.getTotalWordCount());
		System.out.println(warAndPeaceBook.getTotalWordCount());
		System.out.println(siddharthaBook.getTotalWordCount());
		
		//get total word counts from books
		System.out.println("\nGET UNIQUE WORD COUNTS");
		System.out.println(catInTheHatBook.getUniqueWordCount());
		System.out.println(warAndPeaceBook.getUniqueWordCount());
		System.out.println(siddharthaBook.getUniqueWordCount());
		
		//get specific word counts from books
		System.out.println("\nGET SPECIFIC WORD COUNTS");
		System.out.println(catInTheHatBook.getSpecificWordCount("sit"));
		System.out.println(warAndPeaceBook.getSpecificWordCount("love"));
		System.out.println(siddharthaBook.getSpecificWordCount("hate"));
	}
	
}