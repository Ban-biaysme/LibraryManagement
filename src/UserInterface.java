import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import ecs100.UI;

public class UserInterface {

	private List<LibraryTransaction> libraryTrans = new ArrayList<>();	
	private List<Authors> authorList = new ArrayList<Authors>();
	
	public UserInterface() {
		UI.initialise();
		UI.addButton("Read Data", this::loadDatabases);
		UI.addButton("List authors", this::listAuthors);
		UI.addButton("List all books", this::listBooks);
		UI.addButton("List books of author", this::listAuthorBooks);
		UI.addButton("Look up book by title", this::lookUpBook);
		UI.addButton("Issue book", this::issueBook);
		UI.addButton("List Issue book", this::dispIssueBook);
		UI.addButton("QUIT", UI::quit);		
	}
	
		
	public void loadDatabases() {
		File booksDb = new File("books.txt");

		if (booksDb.exists()) {			
			try {
				Scanner scan = new Scanner(booksDb);
				while (scan.hasNext()) {
					
					String authorName="";
					String bookTitle ="";
					int dob =0 ;
					int yod = 0;
					String bookReleaseYear="";					
					authorName = scan.nextLine();						
					dob = scan.nextInt();
						
						if(scan.hasNextInt()) {
							yod = scan.nextInt();
						}
						Authors aobj = new Authors(authorName, dob, yod);
						
						scan.nextLine();
						while(scan.hasNext()) {
							String space= "---";								
							bookTitle = scan.nextLine().trim();
							
							if(bookTitle.equals(space)) {								
								break;
							}
							bookReleaseYear = scan.nextLine();
							
							Books bobj = new Books(bookTitle,authorName,bookReleaseYear );
							libraryTrans.add(bobj);	
							aobj.addBooks(bobj);						
							
							UI.println("Author :" + authorName);
							UI.println("DOB : " + dob);
							UI.println("YOD :" + yod);
							UI.println("Book Title :" + bookTitle);
							UI.println("Released Year :" + bookReleaseYear);
						}
						authorList.add(aobj);						
				}

				scan.close();					
			} catch (IOException e) {
				UI.println("Error: " + e);
			}
			
			} else {
				UI.printf("Could not open %s%n", booksDb);
			}
	}
	
		public void listAuthors() {
			UI.clearText();
			UI.setDivider(1);
			UI.println("******************* AUTHORS LIST ************************");
			for(Authors a : authorList) {
				a.displayRecord();			
			}
		}
	
		public void listBooks() {			
			UI.clearText();
			UI.setDivider(1);	
			UI.println("******************* BOOKS LIST ************************");
			for(Authors a : authorList) {
				for(Books b : a.getBookList()) {				
					UI.println("Book's Name :: " + b.getBookTitle());
					UI.println("Released Year :: " + b.getReleaseYear());
					UI.println("Author's Name:: " + a.getName());
				}
			}
		}
		
		public void listAuthorBooks() {
			UI.println("******************* BOOKS LIST BASED ON AUTHOR'S NAME ************************");
			// List titles of all books by a chosen author
			String aname= UI.askString("Enter the Author's name::");
			
			for(Authors a: authorList) {				
				 if(a.getName().equalsIgnoreCase(aname)) {
					 for(Books b : a.getBookList()) {
						UI.println("Book's Name :: " + b.getBookTitle());
						UI.println("Released Year :: " + b.getReleaseYear());
					 }
				 }
			}
		}
		
		public void lookUpBook() {
			UI.clearText();
			UI.setDivider(1);
			UI.println("******************* BOOKS LIST BASED ON BOOK TITLE ************************");
			// Show book, publication date, and author information	
			String bookTitle = UI.askString("Enter the Book's Title::");
			
			for(Authors a: authorList) {				
				for(Books b: a.getBookList()) {
					if(b.getBookTitle().equalsIgnoreCase(bookTitle)) {
						UI.println("Book's Name :: " + b.getBookTitle());
						UI.println("Publication Date :: " +  b.getReleaseYear());
						UI.println("Author's Name :: " + a.getName());
						UI.println("Author's DOB :: " + a.getDob());
						UI.println("Author's Year of Death :: " + a.getYearOfDeath());
					}
				}
			}
		}
		
		public void issueBook() {
			// Issue a book to a patron.
			
			String bookTitle = UI.askString("Enter the Book's Title::");
			
			for(Authors a: authorList) {												
					for(Books b: a.getBookList()) {
						if(b.getBookTitle().equalsIgnoreCase(bookTitle)) {
							while(true) {
							String customerName = UI.askString("Enter Customer name ::").toLowerCase().trim();
							String cardNumber = UI.askString("Enter Library card number::").toLowerCase().trim();
							Date issuDate = new Date();
							
							BookTransaction bt= new BookTransaction(customerName, cardNumber, issuDate);
							a.addIssueList(bt);
							
							String reply= UI.askString("Do you wish to issue more books yes /no !!").toLowerCase();						
							if(reply.equals("no")) {
								break;
							}
							 bookTitle = UI.askString("Enter the Book's Title::");
						}

					}
				}
			}
			
		}
		
		public void dispIssueBook() {
			UI.clearText();
			UI.setDivider(1);
			UI.println("******************* LIST OF BOOKS ISSUED ON DATE ************************");
			
			for(Authors a: authorList) {	
				for(BookTransaction bt: a.getIssuedBookList()) {					
					UI.println("Customer's Name :: " + bt.getCustomerName() );
					UI.println("Customer's Card Number :: " + bt.getCardNumber());
					UI.println("Book Issue Date :: " + bt.getDateOfIssue());
					UI.println("Book Return Date :: " + bt.getReturnDate());
				}
			}
		}
				
		public static void main(String[] args) {
			new UserInterface();
		}
	}





