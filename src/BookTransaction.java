import java.util.Calendar;
import java.util.Date;

public class BookTransaction {
	private Date dateOfIssue;
	private String customerName;
	private String cardNumber;
	
	public BookTransaction(String customerName, String cardNumber, Date dateOfIssue) {
		this.customerName = customerName;
		this.cardNumber = cardNumber;
		this.dateOfIssue = dateOfIssue;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public Date getReturnDate() {		
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateOfIssue);
		cal.add(Calendar.DATE, 21); 						//21 days after the current date
		Date returnDate= cal.getTime();
		return returnDate;
	}
}

