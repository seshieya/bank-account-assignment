/**
 * Driver to run the Bank
 */
package ca.bcit.comp1451.assignment1;

/**
 * @author ANGELA
 * @version May 22, 2017 - v1
 */
public class Driver {
	public static void main(String[] args) {
		
		Date dob1 = new Date(19, 1, 1988);
		Date dob2 = new Date(20, 8, 1985);
		Date dob3 = new Date(27, 5, 1980);
		Date dob4 = new Date(1, 6, 1955);
		
		Customer c1 = new Customer("Angela", "Wu", "1234 Rainbow Lane", dob1);
		Customer c2 = new Customer("Bruce", "Wayne", "1536 Burnaby Way", dob2);
		Customer c3 = new Customer("Clark", "Kent", "369 Richter Ave", dob3);
		Customer c4 = new Customer("Lois", "Lane", "555 City Way", dob4);
		
		Date accCreationDate1 = new Date(22, 5, 2017);
		Date accCreationDate2 = new Date(15, 6, 2016);
		Date accCreationDate3 = new Date(31, 5, 2017);
		Date accCreationDate4 = new Date(22, 3, 2015);
		
		Account acc1 = new Account(c1, accCreationDate1, 0.0);
		Account acc2 = new Account(c2, accCreationDate2, 0.0);
		Account acc3 = new Account(c3, accCreationDate3, 0.0);
		Account acc4 = new Account(c4, accCreationDate4, 0.0);
		
		Bank bank1 = new Bank("RBC");
		bank1.addAccount(acc1);
		bank1.addAccount(acc2);
		bank1.addAccount(acc3);
		bank1.addAccount(acc4);
		
		bank1.makeTransaction();		
		
	}
}
