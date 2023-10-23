package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SavingsAccountTest {
    SavingsAccount savingsAccount = new SavingsAccount("123456", 5000000);
    SavingsAccount savingsAccount1 = new SavingsAccount("234567", 10000000);

    @Test
    public void getFee() {
        assertEquals(0, savingsAccount.getFee(100000, false), 0.1);//customer NORMAL fee là 0%
        assertEquals(0, savingsAccount.getFee(500000, false), 0.1);//customer NORMAL fee là 0%
        assertEquals(0, savingsAccount1.getFee(100000, true), 0.1);//customer PREMIUM fee là 0%
        assertEquals(0, savingsAccount1.getFee(500000, true), 0.1);//customer PREMIUM fee là 0%
    }

    @Test
    public void withdraw() {
        //số tiền cần rút phải >=50000 và là bội số của 10 000
        assertFalse(savingsAccount.withdraw(40000, false));//số tiền < 50 000
        assertFalse(savingsAccount.withdraw(50001, false));//số tiền không phải bội số của 10 000
        assertFalse(savingsAccount.withdraw(100000000, false));// không đủ tiền trong tài khoản
        assertTrue(savingsAccount.withdraw(4000000, false));//số tiền hợp lệ và tài khoản còn đủ tiền
    }

    @Test
    public void isAccepted() {
        assertFalse(savingsAccount.isAccepted(40000, false));//số tiền < 50 000
        assertFalse(savingsAccount.isAccepted(50001, false));//số tiền không phải bội số của 10 000
        assertFalse(savingsAccount.isAccepted(100000000, false));// không đủ tiền trong tài khoản
        assertTrue(savingsAccount.isAccepted(4000000, false));//số tiền hợp lệ và tài khoản còn đủ tiền
    }
}