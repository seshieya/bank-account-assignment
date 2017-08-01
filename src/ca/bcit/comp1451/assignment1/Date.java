/**
 * 
 */
package ca.bcit.comp1451.assignment1;
import java.util.HashMap;

/**
 * @author ANGELA WU
 * @version May 13, 2017 - v1
 */
public class Date {
	private static final int MIN_DAY = 1;
	private static final int MAX_DAY = 31;
	private static final int MIN_MONTH = 1;
	private static final int MAX_MONTH = 12;
	private static final int MIN_YEAR = 1900;
	private static final int CURRENT_YEAR = 2017;
	private static final int TWO_DIGIT_LIMIT = 10;
	
	private int day;
	private int month;
	private int year;
	
	private HashMap<Integer,String> monthNames;
	
	/**
	 * Constructor for objects of class Date
	 * @param day the day
	 * @param month the month
	 * @param year the year
	 */
	public Date(int day, int month, int year) {
		setDay(day);
		setMonth(month);
		setYear(year);
		
		monthNames = new HashMap<Integer,String>();
		populateMonths();
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return this.day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		if(day >= MIN_DAY && day <= MAX_DAY) {
			this.day = day;
		}
		else {
			this.day = MIN_DAY;
		}
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return this.month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		if(month >= MIN_MONTH && month <= MAX_MONTH) {
			this.month = month;
		}
		else {
			this.month = MIN_MONTH;
		}
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return this.year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		if(year >= MIN_YEAR && year <= CURRENT_YEAR)
		{
			this.year = year;
		}
		else {
			this.year = MIN_YEAR;
		}
	}
	
	/**
	 * Adds month names to the HashMap
	 */
	private void populateMonths() {
		monthNames.put(1, "January");
		monthNames.put(2, "February");
		monthNames.put(3, "March");
		monthNames.put(4, "April");
		monthNames.put(5, "May");
		monthNames.put(6, "June");
		monthNames.put(7, "July");
		monthNames.put(8, "August");
		monthNames.put(9, "September");
		monthNames.put(10, "October");
		monthNames.put(11, "November");
		monthNames.put(12, "December");
	}
	
	/**
	 * Formats the date into a certain format, such as 01/January/2017 
	 * @return The formatted date as a String
	 */
	public String getFormattedDate() {

		String modDate = null;
		String modMonth = null;
		
		if(this.day < TWO_DIGIT_LIMIT) {
			modDate = "0" + this.day;
		}
		else {
			modDate = "" + this.day;
		}
		
		if(monthNames.containsKey(this.month)) {
			modMonth = monthNames.get(this.month);
		}
		
		return modDate + "/" + modMonth + "/" + this.year;
	}
	
	
	
}
