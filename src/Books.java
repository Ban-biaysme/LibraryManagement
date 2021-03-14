import ecs100.UI;

public class Books implements LibraryTransaction{	
		private String bookTitle;
		private String authorName;
		private String releaseYear;
		
		public Books(String bookTitle,String authorName,String releaseYear) {		
		this.bookTitle =bookTitle;
		this.authorName = authorName;
		this.releaseYear = releaseYear;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
		
	public void displayRecord() {
		UI.println("Book's Title:: " + this.bookTitle);
		UI.println("Author Name:: " + this.authorName);
		UI.println("Release Year:: " + this.releaseYear);
	}	
	
}
