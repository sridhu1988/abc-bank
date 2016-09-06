package com.abc;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test //Test customer statement generation
    public void testApp(){

        Account checkingAccount = new Account(Account.CHECKING);
        Account savingsAccount = new Account(Account.SAVINGS);

        Customer henry = new Customer("Henry").openAccount(checkingAccount).openAccount(savingsAccount);

        checkingAccount.deposit(100.0);
        savingsAccount.deposit(4000.0);
        savingsAccount.withdraw(200.0);

        assertEquals("Statement for Henry\n" +
                "\n" +
                "Checking Account\n" +
                "  deposit $100.00\n" +
                "Total $100.00\n" +
                "\n" +
                "Savings Account\n" +
                "  deposit $4,000.00\n" +
                "  withdrawal $200.00\n" +
                "Total $3,800.00\n" +
                "\n" +
                "Total In All Accounts $3,900.00", henry.getStatement());
    }

    @Test
    public void testOneAccount(){
        Customer oscar = new Customer("Oscar").openAccount(new Account(Account.SAVINGS));
        assertEquals(1, oscar.getNumberOfAccounts());
    }

    @Test
    public void testTwoAccount(){
        Customer oscar = new Customer("Oscar")
                .openAccount(new Account(Account.SAVINGS));
        oscar.openAccount(new Account(Account.CHECKING));
        assertEquals(2, oscar.getNumberOfAccounts());
    }

    @Ignore
    public void testThreeAcounts() {
        Customer oscar = new Customer("Oscar")
                .openAccount(new Account(Account.SAVINGS));
        oscar.openAccount(new Account(Account.CHECKING));
        assertEquals(3, oscar.getNumberOfAccounts());
    }
    
    @Test
 	public void testForMulSavingsAccounts() {
 		Customer oscar = new Customer("Oscar").openAccount(new Account(Account.SAVINGS));
 		oscar.openAccount(new Account(Account.SAVINGS));
 		assertEquals(2, oscar.getNumberOfAccounts());
 	}
 
 	@Test
 	public void testForMulCheckingAccounts() {
 		Customer oscar = new Customer("Oscar").openAccount(new Account(Account.CHECKING));
 		oscar.openAccount(new Account(Account.CHECKING));
 		assertEquals(2, oscar.getNumberOfAccounts());
 	}
 
 
 	@Test
 	public void testMulMaxiSavingsAccounts() {
 		Customer oscar = new Customer("Oscar").openAccount(new Account(Account.MAXI_SAVINGS));
 		oscar.openAccount(new Account(Account.MAXI_SAVINGS));
 		assertEquals(2, oscar.getNumberOfAccounts());
 	}
 
	@Test
 	public void testSavingsInterest() {
 
 		Account savingsAccount = new Account(Account.SAVINGS);
 
 		Customer henry = new Customer("Henry").openAccount(savingsAccount);
 
 		savingsAccount.deposit(5000.0);
 		assertEquals(9.0, savingsAccount.interestEarned(), Constants.DOUBLE_DELTA);
 	}
 
 	@Test 
 	public void testCheckingsInterest() {
 
 		Account checkingAccount = new Account(Account.CHECKING);
 
 		Customer henry = new Customer("Henry").openAccount(checkingAccount);
 
 		checkingAccount.deposit(5000.0);
 		assertEquals(5.0, checkingAccount.interestEarned(), Constants.DOUBLE_DELTA);
 	}
 
 	@Test 
 	public void testMaxiSavingsInterest() {
 
 		Account maxiSavingsAccount = new Account(Account.MAXI_SAVINGS);
 
 		Customer henry = new Customer("Henry").openAccount(maxiSavingsAccount);
 
 		maxiSavingsAccount.deposit(5000.00);
 		assertEquals(250.00, maxiSavingsAccount.interestEarned(), Constants.DOUBLE_DELTA);
 	}
}
