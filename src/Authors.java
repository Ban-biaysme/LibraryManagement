import java.util.ArrayList;
import ecs100.UI;

public class Authors {
		private String authorName;
		private int dob;
		private int yearOfDeath;
		
	private ArrayList<Books> bookList= new ArrayList<Books>();
	private ArrayList<BookTransaction> bookTrans= new ArrayList<BookTransaction>();
		
	public Authors(String authorName, int dob, int yearOfDeath) {
		this.authorName =authorName;
		this.dob = dob;
		this.yearOfDeath = yearOfDeath;	
	}

	public String getName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getDob() {
		return dob;
	}

	public void setDob(int dob) {
		this.dob = dob;
	}

	public int getYearOfDeath() {
		return yearOfDeath;
	}

	public void setYearOfDeath(int yearOfDeath) {
		this.yearOfDeath = yearOfDeath;
	}

	public void addBooks(Books b) {
		bookList.add(b);
	}
	
	public ArrayList<Books> getBookList() {
		return bookList;
	}

	public void setBookList(ArrayList<Books> bookList) {
		this.bookList = bookList;
	}
	
	public void addIssueList(BookTransaction bt) {
		bookTrans.add(bt);
	}
	
	public void setIssuedBookList(ArrayList<BookTransaction> issueList) {
		this.bookTrans = issueList;
	}
	
	public ArrayList<BookTransaction> getIssuedBookList() {
		return bookTrans;
	}

	public void displayRecord() {
		UI.println("Author's Name::: " + this.authorName);
		UI.println("Author DOB:: " + this.dob);
		UI.println("Author Died:: " + this.yearOfDeath);		
	}
}
