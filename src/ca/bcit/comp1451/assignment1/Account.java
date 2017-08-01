/**
 * 
 */
package ca.bcit.comp1451.assignment1;

import java.util.ArrayList;

/**
 * @author ANGELA WU
 * @version May 14, 2017 - v1
 */
public class Account {
	private static final int MIN_AMOUNT = 0;
	private static int uniqueAccNumber = 0;
	
	
	private Customer customer;
	private String accountNumber;
	private Date accCreatedDate;
	private double balance;
	private ArrayList<TransactionRecord> transactions;
	
	/**
	 * Constructor for objects of class Account
	 * @param customer the customer
	 * @param accCreatedDay the day of the date that account was created
	 * @param accCreatedMonth the month of the date that account was created
	 * @param accCreatedYear the year of the date that account was created
	 * @param balance the initial balance of the account when it was created
	 */
	public Account(Customer customer, Date accCreatedDate, double balance) {
		setCustomer(customer);
		setAccCreatedDate(accCreatedDate);
		setBalance(balance);
		
		transactions = new ArrayList<TransactionRecord>();
		
		createAccNumber();
	}


	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		if(customer != null) {
			this.customer = customer;
		}

	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	/*
	public void setAccountNumber(String accountNumber) {
		if(accountNumber != null) {
			this.accountNumber = accountNumber;
		}
	}
	*/

	/**
	 * @return the accCreatedDate
	 */
	public Date getAccCreatedDate() {
		return accCreatedDate;
	}

	/**
	 * @param accCreatedDate the accCreatedDate to set
	 */
	public void setAccCreatedDate(Date accCreatedDate) {
		if(accCreatedDate != null) {
			this.accCreatedDate = accCreatedDate;
		}
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		if(balance >= MIN_AMOUNT) {
			this.balance = balance;
		}
	}

	
	/**
	 * @return the transactions in the ArrayList
	 */
	
	public ArrayList<TransactionRecord> getTransactions() {
		return transactions;
	}
	


	/**
	 * @param transactions the transactions to set
	 */
	/*
	public void setTransRecord(ArrayList<TransactionRecord> transactions) {
		this.transactions = transactions;
	}
	*/
	

	/**
	 * Generate unique number for each account created
	 */
	private void createAccNumber() {
		uniqueAccNumber++;
		this.accountNumber = "" + uniqueAccNumber;
	}
	
	
	/**
	 * @param amount the amount to deposit
	 * @return true for valid deposit (positive numbers), false for invalid deposits (negative numbers)
	 */
	public boolean deposit(double amount) { 
		if(amount >= MIN_AMOUNT) {
			this.balance = this.balance + amount;
			return true;
		}
		
		System.out.println("Deposit amount is invalid.");
		return false;
	}
	
	/**
	 * @param amount the amount to withdraw
	 * @return true for valid withdraw (positive numbers), false for invalid withdraw (negative numbers)
	 */
	public boolean withdraw(double amount) {
		
		if(amount >= MIN_AMOUNT && ((this.balance - amount) >= MIN_AMOUNT)) {
			this.balance = this.balance - amount;
			return true;
		}
		
		System.out.println("Withdrawal amount is invalid, or withdrawal amount exceeds your balance.");
		return false;
	}
	
	/**
	 * Add a new transaction to the TransactionRecord ArrayList
	 * @param transaction the transaction to add to the ArrayList
	 * 
	 */
	public void addTransaction(TransactionRecord transaction) {
		transactions.add(transaction);
	}
	
	/**
	 * Displays all transaction details for an account
	 */
	public void displayTransactionDetails() {
		for(TransactionRecord records : transactions) {
			System.out.println(records.getTransactionRecord());
		}
	}
	
	/**
	 * Displays all details of an account
	 */
	public void displayAccountDetails() {
		System.out.print("Customer name: ");
		getCustomer().displayFullName();
		System.out.println("Account number: " + getAccountNumber());
		System.out.println("Balance: " + getBalance());
		System.out.println("Date account created: " + getAccCreatedDate().getFormattedDate());
	}
	
}
