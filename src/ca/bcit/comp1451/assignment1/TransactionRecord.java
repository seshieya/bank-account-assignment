/**
 * 
 */
package ca.bcit.comp1451.assignment1;

/**
 * @author ANGELA WU
 * @version May 14, 2017 - v1
 */
public class TransactionRecord {
	private double amount;
	private Date dateIssued;
	private String accountNumber;
	private String transactionType;
	
	/**
	 * Constructor for objects of class TransactionRecord
	 * @param amount the amount withdrawn or deposited
	 * @param dateIssued date the withdraw or deposit was issued
	 */
	public TransactionRecord(double amount, Date dateIssued) {
		setAmount(amount);
		setDateIssued(dateIssued);
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return this.amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		if(amount > 0) {
			this.amount = amount;
		}
		else {
			this.amount = 0.0;
		}
	}

	/**
	 * @return the dateIssued
	 */
	public Date getDateIssued() {
		return this.dateIssued;
	}

	/**
	 * @param dateIssued the dateIssued to set
	 */
	public void setDateIssued(Date dateIssued) {
		if(dateIssued != null) {
			this.dateIssued = dateIssued;
		}
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return this.accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		if(accountNumber != null && !accountNumber.isEmpty()) {
			this.accountNumber = accountNumber;
		}
	}

	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		if(transactionType != null && !transactionType.isEmpty()) {
			this.transactionType = transactionType;
		}
	}
	
	/**
	 * @return information about the type of transaction you made, the amount deposited or withdrawn, and the date of the transaction
	 */
	public String getTransactionRecord() {
		return 	"Type of transaction: " + getTransactionType() + "\n" +
				"Amount: " + getAmount() + "\n" + 
				"Date of transaction: " + getDateIssued().getFormattedDate() + "\n";

	}

	
}
