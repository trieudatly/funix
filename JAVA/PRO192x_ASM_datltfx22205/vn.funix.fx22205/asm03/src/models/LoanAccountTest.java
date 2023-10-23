package models;

import static org.junit.Assert.*;

public class LoanAccountTest {

    LoanAccount loanAccount = new LoanAccount("987654");
    LoanAccount loanAccount1 = new LoanAccount("876543");


    @org.junit.Test
    public void getFee() {
        assertEquals(5000, loanAccount.getFee(100000, false), 0.1);//customer NORMAL fee là 5%
        assertEquals(25000, loanAccount.getFee(500000, false), 0.1);//customer NORMAL fee là 5%
        assertEquals(1000, loanAccount1.getFee(100000, true), 0.1);//customer PREMIUM fee là 1%
        assertEquals(5000, loanAccount1.getFee(500000, true), 0.1);//customer PREMIUM fee là 1%
    }

    @org.junit.Test
    public void withdraw() {
        //số tiền cần rút phải >=50000 và là bội số của 10 000
        assertFalse(loanAccount.withdraw(40000, false));//số tiền < 50 000
        assertFalse(loanAccount.withdraw(50001, false));//số tiền không phải bội số của 10 000
        assertFalse(loanAccount.withdraw(100000000, false));// không đủ tiền trong tài khoản
        assertTrue(loanAccount.withdraw(10000000, false));//số tiền hợp lệ và tài khoản còn đủ tiền
    }

    @org.junit.Test
    public void isAccepted() {
        assertFalse(loanAccount.isAccepted(40000, false));//số tiền < 50 000
        assertFalse(loanAccount.isAccepted(50001, false));//số tiền không phải bội số của 10 000
        assertFalse(loanAccount.isAccepted(100000000, false));// không đủ tiền trong tài khoản
        assertTrue(loanAccount.isAccepted(10000000, false));//số tiền hợp lệ và tài khoản còn đủ tiền
    }

}