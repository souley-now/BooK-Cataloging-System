package book.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Manages the loading of book files.
 */
public class BookFileReader {

	/**
	 * Parses a book file and returns a list of lines.
	 * @param fileName the name of the file to parse
	 * @return a list of lines from the file
	 */

	public static List<String> parseFile(String fileName) {

		List<String> lines = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

			String line = reader.readLine();
			while (line != null) {
				line = line.trim();
				if (!line.isEmpty()) {
					lines.add(line);
				}
				line = reader.readLine();
			}

		} catch (IOException e) {
			System.err.println("Error reading file: " + fileName);
			e.printStackTrace();
		}

		return lines;
	}

	
	///// DO NOT CHANGE CODE IN MAIN METHOD! /////
	public static void main(String[] args) {
		
		//load and parse book file cat in the hat
		List<String> catInTheHat = BookFileReader.parseFile("the_cat_in_the_hat_snippet.txt");
		
		//get first 10 lines of cat in the hat
		System.out.println("GET FIRST 10 LINES FROM CAT IN THE HAT\n");
		int count = 0;
		for (String line : catInTheHat) {
			System.out.println(line);
			if (count > 8) {
				break;
			}
			count++;
		}
		
		
		//load and parse book file war and peace
		List<String> warAndPeace = BookFileReader.parseFile("war_and_peace.txt");
		
		//get first 10 lines of war and peace
		System.out.println("\n\nGET FIRST 10 LINES FROM WAR AND PEACE\n");
		count = 0;
		for (String line : warAndPeace) {
			System.out.println(line);
			if (count > 8) {
				break;
			}
			count++;
		}
		
		//load and parse book file siddhartha
		List<String> siddhartha = BookFileReader.parseFile("siddhartha.txt");
		
		//get first 10 lines of siddhartha
		System.out.println("\n\nGET FIRST 10 LINES FROM SIDDHARTHA\n");
		count = 0;
		for (String line : siddhartha) {
			System.out.println(line);
			if (count > 8) {
				break;
			}
			count++;
		}
		
	}
}