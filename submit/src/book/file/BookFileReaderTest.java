package book.file;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import book.file.BookFileReader;

class BookFileReaderTest {
	
	// lists to store lines from different loaded book files
	List<String> catInTheHat;
	List<String> warAndPeace;
	List<String> siddhartha;

	@BeforeEach
	void setUp() throws Exception {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//load and parse cat in the hat snippet book file
		this.catInTheHat = BookFileReader.parseFile("the_cat_in_the_hat_snippet.txt");
		
		//load and parse war and peace book file
		this.warAndPeace = BookFileReader.parseFile("war_and_peace.txt");
		
		//load and parse siddhartha book file
		this.siddhartha = BookFileReader.parseFile("siddhartha.txt");
    
		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////
		
	}

	@Test
	void testParseFile() {

		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//create array with first 10 expected lines of cat in the hat snippet
		String[] expectedLines1Array = {
			"Title: The Cat in the Hat",
			"Author: Dr. Seuss",
			"The sun did not shine.",
			"It was too wet to play.",
			"So we sat in the house",
			"All that cold, cold, wet day.",
			"I sat there with Sally.",
			"We sat there, we two.",
			"And I said, \"How I wish",
			"We had something to do!\""
		};
		List<String> expectedLines1 = new ArrayList<String>(Arrays.asList(expectedLines1Array));
		
		//compare to first 10 actual lines of cat in the hat snippet
		assertEquals(expectedLines1, this.catInTheHat.subList(0, 10), "The expected 10 lines do not match the actual first 10 'Cat in the Hat' book lines.");
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////
		
		
		// Test case for War and Peace
		String[] expectedLines2Array = {
			"Title: War and Peace",
			"Author: Leo Tolstoy",
			"Well, Prince, so Genoa and Lucca are now just family estates of the Buonapartes.",
			"But I warn you, if you don't tell me that this means war,",
			"if you still try to defend the infamies and horrors perpetrated by that Antichrist—",
			"I really believe he is an Antichrist—I will have nothing to do with you and you are no longer my friend,",
			"and no longer my 'faithful slave', as you call yourself!",
			"But how do you do? I see I have frightened you—sit down and tell me all the news."
		};
		List<String> expectedLines2 = new ArrayList<String>(Arrays.asList(expectedLines2Array));
		
		assertEquals(expectedLines2, this.warAndPeace.subList(0, 8), "The expected 8 lines do not match the actual first 8 'War and Peace' book lines.");
		
		
		// Test case for Siddhartha
		String[] expectedLines3Array = {
			"Title: Siddhartha",
			"Author: Hermann Hesse",
			"In the shade of the house, in the sunshine of the riverbank near the boats,",
			"in the shade of the Sal-wood forest, in the shade of the fig tree is where Siddhartha grew up,",
			"the handsome son of the Brahman, the young falcon,",
			"together with his friend Govinda, son of a Brahman.",
			"The sun browned his slender shoulders on the riverbank,",
			"while bathing, performing the sacred ablutions,",
			"the sacred offerings."
		};
		List<String> expectedLines3 = new ArrayList<String>(Arrays.asList(expectedLines3Array));
		
		assertEquals(expectedLines3, this.siddhartha.subList(0, 8), "The expected 8 lines do not match the actual first 8 'Siddhartha' book lines.");
	}
}
