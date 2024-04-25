package test;

import model.SavingAccount;
import org.junit.Test;

import static org.junit.Assert.*;

public class SavingAccountTest {

    SavingAccount savingAccount1 = new SavingAccount("123456", 10000000, "001215000001");
    SavingAccount savingAccount2 = new SavingAccount("234567", 50000, "001215000002");

    @Test
    public void isAccepted() {
        assertFalse(savingAccount1.isAccepted(40000, false));//số tiền < 50 000
        assertFalse(savingAccount1.isAccepted(50001, false));//số tiền không phải bội số của 10 000
        assertFalse(savingAccount1.isAccepted(100000000, false));// không đủ tiền trong tài khoản
        assertTrue(savingAccount1.isAccepted(4000000, false));//số tiền hợp lệ và tài khoản còn đủ tiền
    }

    @Test
    public void getFee() {
        assertEquals(0, savingAccount1.getFee(100000, false), 0.1);//customer NORMAL fee là 0%
        assertEquals(0, savingAccount1.getFee(500000, false), 0.1);//customer NORMAL fee là 0%
        assertEquals(0, savingAccount1.getFee(100000, true), 0.1);//customer PREMIUM fee là 0%
        assertEquals(0, savingAccount1.getFee(500000, true), 0.1);//customer PREMIUM fee là 0%
    }


}