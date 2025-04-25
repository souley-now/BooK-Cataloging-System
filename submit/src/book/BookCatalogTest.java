// 20220418
package book;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import book.file.BookFileReader;

class BookCatalogTest {

	// lists to store lines from different loaded book files
	List<String> catInTheHat;
	List<String> warAndPeace;
	List<String> siddhartha;

	// book objects to be created from lines 
	Book catInTheHatBook;
	Book warAndPeaceBook;
	Book siddharthaBook;
		
	@BeforeEach
	void setUp() throws Exception {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////

		//load and parse cat in the hat snippet book file
		this.catInTheHat = BookFileReader.parseFile("the_cat_in_the_hat_snippet.txt");
		
		//create book object from list of lines from cat in the hat snippet
		this.catInTheHatBook = new Book(this.catInTheHat);
		
		//load and parse war and peace book file
		this.warAndPeace = BookFileReader.parseFile("war_and_peace.txt");
		
		//create book object from list of lines from war and peace
		this.warAndPeaceBook = new Book(this.warAndPeace);
		
		//load and parse siddhartha book file
		this.siddhartha = BookFileReader.parseFile("siddhartha.txt");
		
		//create book object from list of lines from siddhartha
		this.siddharthaBook = new Book(this.siddhartha);
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////
				
	}

	@Test
	void testAddBook() {
		
		//////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! /////
		
		BookCatalog bookCatalog = new BookCatalog();

		//create book with title, and add to catalog
		List<String> bookLines = new ArrayList<String>();
		bookLines.add("Title: Test Book Title");
		Book book = new Book(bookLines);
		bookCatalog.addBook(book);
		
		//catalog should contain 1 book
		assertEquals(1, bookCatalog.getBookMap().size(), "After adding 1 book to an empty book catalog, the book catalog should now have 1 book.");
		
		//create another book with title, and add to catalog
		bookLines = new ArrayList<String>();
		bookLines.add("Title:    Another Book Title");
		book = new Book(bookLines);
		bookCatalog.addBook(book);
		
		//catalog should contain 2 books
		assertEquals(2, bookCatalog.getBookMap().size(), "After adding 1 book to a book catalog that already had 1 book, the book catalog should now have 2 books.");
		
		
		//add cat in the hat
		bookCatalog.addBook(this.catInTheHatBook);

		//catalog should contain 3 books
		assertEquals(3, bookCatalog.getBookMap().size(), "After adding 'The Cat in the Hat' to a book catalog that already had 2 books, the book catalog should now have 3 books.");
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! /////
		//////////////////////////////////////////////
		
		
		// TODO insert 2 additional test cases
        // Hint(s): Add war and peace and siddhartha book objects and check bookmap 

		//Test case 1: Add "War and Peace" book object to book catalog
		bookLines = new ArrayList<String>();
		bookLines.add("Title: War and Peace");
		book = new Book(bookLines);
		bookCatalog.addBook(book);

		//catalog should contain 4 books
		assertEquals(4, bookCatalog.getBookMap().size(), "After adding 'War and Peace' to a book catalog that already had 3 books, the book catalog should now have 4 books.");

		//Test case 2: Add "Siddhartha" book object to book catalog
		bookLines = new ArrayList<String>();
		bookLines.add("Title: Siddhartha");
		book = new Book(bookLines);
		bookCatalog.addBook(book);

		//catalog should contain 5 books
		assertEquals(5, bookCatalog.getBookMap().size(), "After adding 'Siddhartha' to a book catalog that already had 4 books, the book catalog should now have 5 books.");

	}

	@Test
	void testGetBookByTitle() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//create book catalog
		BookCatalog bookCatalog = new BookCatalog();
		
		//create book with title and add to catalog
		List<String> bookLines = new ArrayList<String>();
		bookLines.add("Title: Test Book Title");
		Book book = new Book(bookLines);
		bookCatalog.addBook(book);
		
		//get book from catalog
		Book catalogBook = bookCatalog.getBookByTitle("Test Book Title");
		
		//test book
		assertEquals("Test Book Title", catalogBook.getTitle(), "The expected title does not match the actual title from the book from the catalog.");
		
		//create another book and add to catalog
		bookLines = new ArrayList<String>();
		bookLines.add("Title:     Another Book Title");
		book = new Book(bookLines);
		bookCatalog.addBook(book);
		
		//get book from catalog
		catalogBook = bookCatalog.getBookByTitle("Another Book Title");
		
		//test book
		assertEquals("Another Book Title", catalogBook.getTitle(), "The expected title does not match the actual title from the book from the catalog.");
		
		//add cat in the hat
		bookCatalog.addBook(this.catInTheHatBook);

		//get book from catalog
		catalogBook = bookCatalog.getBookByTitle("The Cat in the Hat");
		
		//test book
		assertEquals("The Cat in the Hat", catalogBook.getTitle(), "The expected title does not match the actual title from 'The Cat in the Hat' book from the catalog.");
		
		///// DO NOT MODIFY THE TEST CODE ABOVE! /////
		//////////////////////////////////////////////
		
		
		// TODO insert 2 additional test cases
        // Hint(s): Add war and peace and siddhartha book objects and get them by title

		// test case for a book that does not exist in the catalog
		catalogBook = bookCatalog.getBookByTitle("In Search of Lost Time");
		assertNull(catalogBook, "Expected null as book is not present in the catalog.");

		// test case for a book with leading/trailing spaces in title
		bookLines = new ArrayList<String>();
		bookLines.add("Title:  Siddhartha  ");
		book = new Book(bookLines);
		bookCatalog.addBook(book);
		catalogBook = bookCatalog.getBookByTitle("Siddhartha");
		assertEquals("Siddhartha", catalogBook.getTitle().trim(), "The expected title does not match the actual title from 'Siddhartha' book from the catalog.");

		// test case for a book with special characters in title
		bookLines = new ArrayList<String>();
		bookLines.add("Title: War & Peace");
		book = new Book(bookLines);
		bookCatalog.addBook(book);
		catalogBook = bookCatalog.getBookByTitle("War & Peace");
		assertEquals("War & Peace", catalogBook.getTitle(), "The expected title does not match the actual title from 'War & Peace' book from the catalog.");

	}

	@Test
	void testGetBookByAuthor() {
		
		////////////////////////////////////////////////
		///// DO NOT MODIFY THE TEST CODE BELOW! ///////
		
		//create book catalog
		BookCatalog bookCatalog = new BookCatalog();
		
		//create book with title and author and add to catalog
		List<String> bookLines = new ArrayList<String>();
		bookLines.add("Title: My Book Title");
		bookLines.add("Author: Joseph Berry");
		Book book = new Book(bookLines);
		bookCatalog.addBook(book);
		
		//get book from catalog
		Book catalogBook = bookCatalog.getBookByAuthor("Joseph Berry");
		
		//test book
		assertEquals("Joseph Berry", catalogBook.getAuthor(), "The expected author does not match the actual author from the book from the catalog.");
		
		//create another book and add to catalog
		bookLines = new ArrayList<String>();
		bookLines.add("Title:     My Other Book Title");
		bookLines.add("Author:    Rhonda Fierri");
		book = new Book(bookLines);
		bookCatalog.addBook(book);
		
		//get book from catalog
		catalogBook = bookCatalog.getBookByAuthor("Rhonda Fierri");
		
		//test book
		assertEquals("Rhonda Fierri", catalogBook.getAuthor(), "The expected author does not match the actual author from the book from the catalog.");
		
		//add cat in the hat
		bookCatalog.addBook(this.catInTheHatBook);

		//get book from catalog
		catalogBook = bookCatalog.getBookByAuthor("Dr. Seuss");
		
		//test book
		assertEquals("Dr. Seuss", catalogBook.getAuthor(), "The expected author does not match the actual author from 'The Cat in the Hat' book from the catalog.");

		///// DO NOT MODIFY THE TEST CODE ABOVE! ///////
		////////////////////////////////////////////////

		
		// TODO insert 2 additional test cases
        // Hint(s): Add war and peace and siddhartha book objects and get them by author
		// to the bookCatalog and get them by their respective author name
		bookLines = new ArrayList<String>();
		bookLines.add("Title: War and Peace");
		bookLines.add("Author: Leo Tolstoy");
		book = new Book(bookLines);
		bookCatalog.addBook(book);

		//get book from catalog
		catalogBook = bookCatalog.getBookByAuthor("Leo Tolstoy");

		//test book
		assertEquals("Leo Tolstoy", catalogBook.getAuthor(), "The expected author does not match the actual author from 'War and Peace' book from the catalog.");

		bookLines = new ArrayList<String>();
		bookLines.add("Title: Siddhartha");
		bookLines.add("Author: Hermann Hesse");
		book = new Book(bookLines);
		bookCatalog.addBook(book);

		//get book from catalog
		catalogBook = bookCatalog.getBookByAuthor("Hermann Hesse");

		//test book
		assertEquals("Hermann Hesse", catalogBook.getAuthor(), "The expected author does not match the actual author from 'Siddhartha' book from the catalog.");
	}

}