/**
 * 
 */
package ca.bcit.comp1451.assignment1;

/**
 * @author ANGELA WU
 * @version May 12, 2017 - v1
 */
public class Customer {
	private String firstName;
	private String lastName;
	private String address;
	private Date dateOfBirth;
	
	/**
	 * Constructor for objects of class Customer
	 * @param firstName the first name of the customer
	 * @param lastName the last name of the customer
	 * @param address the address of the customer
	 * @param bday the day of the birth date of the customer
	 * @param bmonth the month of the birth date of the customer
	 * @param byear the year of the birth date of the customer
	 */
	public Customer(String firstName, String lastName, String address, Date dateOfBirth) {
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setDateOfBirth(dateOfBirth);
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		if(firstName != null && !firstName.isEmpty()) {
			String formattedName = formatName(firstName);
			this.firstName = formattedName;
		}
		else {
			this.firstName = "unknown";
		}
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		if(lastName != null && !lastName.isEmpty()) {
			String formattedName = formatName(lastName);
			this.lastName = formattedName;
		}
		else {
			this.lastName = "unknown";
		}
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		if(address != null && !address.isEmpty()) {
			this.address = address;
		}
		else {
			this.address = "unknown";
		}
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		if(dateOfBirth != null) {
			this.dateOfBirth = dateOfBirth;
		}
		
	}
	
	/**
	 * Method to format the customer's name, with the first letter of the name as upper case, the rest as lower case
	 * @param name the name to format
	 * @return the formatted name
	 */
	public String formatName(String name) {
		String formattedName = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
		return formattedName;
	}
	
	/**
	 * Displays full name of the customer
	 */
	public void displayFullName() {
		System.out.println(firstName + " " + lastName);
	}
	
	/**
	 * Displays all of the customers in a Bank
	 */
	public void displayAllCustomers() {
		System.out.print("Name: ");
		displayFullName();
		System.out.println("Address: " + address);
		System.out.println("Date of Birth: " + dateOfBirth.getFormattedDate());
	}

	
}
