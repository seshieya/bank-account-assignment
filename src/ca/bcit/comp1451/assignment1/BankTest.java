package ca.bcit.comp1451.assignment1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BankTest {
	private Bank b1;


	@Before
	public void setUp() throws Exception {
		b1 = new Bank("RBC");
		
	}

	@After
	public void tearDown() throws Exception {
		b1 = null;
	}
	
	@Test
	public void testBankNamePositive() {
		Bank bank = new Bank("BMO");
		assertEquals("BMO", bank.getBankName());
	}
	
	@Test
	public void testBankNameNegativeEmptyString() {
		Bank bank = new Bank("");
		assertEquals("unknown", bank.getBankName());
	}
	
	@Test
	public void testBankNameNegativeNull() {
		Bank bank = new Bank(null);
		assertEquals("unknown", bank.getBankName());
	}
	
	@Test
	public void testBankNameBoundary() {
		Bank bank = new Bank("A");
		assertEquals("A", bank.getBankName());
	}
	

	@Test
	public void testSetBankNamePositive() {
		b1.setBankName("Scotiabank");
		assertEquals("Scotiabank", b1.getBankName());
	}
	
	@Test
	public void testSetBankNameNegativeEmptyString() {
		b1.setBankName("");
		assertEquals("unknown", b1.getBankName());
	}
	
	@Test
	public void testSetBankNameBoundary() {
		b1.setBankName("A");
		assertEquals("A", b1.getBankName());
	}


	@Test
	public void testAddAccountPositive() {
		Date dob = new Date(20, 5, 1988);
		Customer cus = new Customer("Angela", "Wu", "1234 Rainbow Lane", dob);
		
		Date accCreation = new Date(29, 5, 2017);
		Account acc =  new Account(cus, accCreation, 0.0);
		b1.addAccount(acc);
		assertEquals(acc, b1.getAccount("1"));
	}
	
	@Test
	public void testAddAccountNegative() {
		b1.addAccount(null);
		assertEquals(null, b1.getAccount("1"));
	}
	
}