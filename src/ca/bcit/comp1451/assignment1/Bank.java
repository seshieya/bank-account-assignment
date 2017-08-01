/**
 * 
 */
package ca.bcit.comp1451.assignment1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author ANGELA WU	
 * @version May 22, 2017 - v1
 */
public class Bank {
	private String bankName;
	private HashMap<String,Account> accounts;
	
	/**
	 * Constructor for objects of class Bank
	 * @param bankName  Name of the bank
	 */
	public Bank(String bankName) {
		setBankName(bankName);
		
		accounts = new HashMap<String,Account>();
	}

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return this.bankName;
	}
	
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		if(bankName != null && !bankName.isEmpty()) {
			this.bankName = bankName;
		}
		else {
			this.bankName = "unknown";
		}
	}
	
	/**
	 * Adds an account to the HashMap
	 * @param toadd the account to add
	 */
	public void addAccount(Account toadd) {
		if(toadd != null) {
			accounts.put(toadd.getAccountNumber(), toadd);
		}
	}
	
	/**
	 * Get the account from the accounts HashMap
	 * @param accountNumber the account number
	 * @return the account number
	 */
	public Account getAccount(String accountNumber) {
		if(accountNumber != null && accounts.containsKey(accountNumber)) {
			Account foundAccount = accounts.get(accountNumber);
			return foundAccount;
		}
		
		return null;
	}
	
	/**
	 * Searches through the accounts HashMap for the requested account
	 * @param accountNumber the account number
	 */
	public void getTransactionsForAccount(String accountNumber) {
		if(accounts.containsKey(accountNumber)) {
			Account foundAccount = accounts.get(accountNumber);
			
			foundAccount.displayTransactionDetails();
		
		}
		else {
			System.out.println("Account number doesn't exist.");
		}
	}
	
	/**
	 * Displays a welcome message to the customer
	 * @param chosen the account that was selected
	 */
	public void displayChosenAccount(Account chosen) {
		System.out.print("Welcome ");
		chosen.getCustomer().displayFullName();
	}
	
	/**
	 * Makes a transaction (deposit or withdraw), and can also pull show transactions made to a selected account
	 */
	public void makeTransaction() {
		Scanner input = new Scanner(System.in);
		
		boolean transActive = true;
		
		while(transActive) {
			System.out.println("Enter account number:");
			String accountNumber = input.next();
					
			if(accounts.containsKey(accountNumber)) {
				
				Account chosenAccount = accounts.get(accountNumber);
				
				displayChosenAccount(chosenAccount);
				
				System.out.println("1. Deposit");
				System.out.println("2. Withdraw");
				System.out.println("3. Show Transactions");
				
				System.out.println("\nPlease enter transaction type (enter 1, 2, or 3):");
				int transType = input.nextInt();
				
				if(transType == 1 || transType == 2) {
					System.out.println("Please enter amount:");
					int amount = input.nextInt();
					
					System.out.println("Please enter date to post the transaction:");
					System.out.println("Day: ");
					int day = input.nextInt();
					
					System.out.println("Month: ");
					int month = input.nextInt();
					
					System.out.println("Year: ");
					int year = input.nextInt();
					
					Date postedDate = new Date(day, month, year);
									
					if(transType == 1 && chosenAccount.deposit(amount)) {
						TransactionRecord depositRecord = new TransactionRecord(amount, postedDate);
						depositRecord.setAccountNumber(chosenAccount.getAccountNumber());
						depositRecord.setTransactionType("deposit");
						chosenAccount.addTransaction(depositRecord);
					}
					else if(transType == 2 && chosenAccount.withdraw(amount)) {
						TransactionRecord withdrawRecord = new TransactionRecord(amount, postedDate);
						withdrawRecord.setAccountNumber(chosenAccount.getAccountNumber());
						withdrawRecord.setTransactionType("withdraw");
						chosenAccount.addTransaction(withdrawRecord);
					}
					else {
						break;
					}
				}
				else if(transType == 3) {
					if(accounts.get(accountNumber).getTransactions().size() == 0) {
						System.out.println("No transactions have been made for this account.");
					}
					else {
						getTransactionsForAccount(accountNumber);
						
						//System.out.println("Current balance: " + accounts.get(accountNumber).getBalance());
					}
					
				}
				else {
					System.out.println("Invalid option.");
				}
						
				boolean proceed = true;
				
				System.out.println("\nWould you like to make another transaction? Please enter yes or no:");
				
				while(proceed) {
					String continueTrans = input.next();				
					if(continueTrans.equalsIgnoreCase("no")) {
						transActive = false;
						proceed = false;
					}
					else if(continueTrans.equalsIgnoreCase("yes")) {
						transActive = true;
						proceed = false;
					}
					else {
						System.out.println("Invalid input. Please enter yes or no:");
					}
				}	
			}
			else {
				System.out.println("The account was not found");
				transActive = false;
			}
			
		}
		
		input.close();
	}
	
	
	
}
