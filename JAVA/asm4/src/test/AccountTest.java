package test;

import model.SavingAccount;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AccountTest {
    SavingAccount account = new SavingAccount("123456", 5000000, "001215000001");
    SavingAccount account1 = new SavingAccount("123546", 10000000, "001215000001");
    SavingAccount account2 = new SavingAccount("654321", 100000000, "001215000001");

    @Test
    public void isPremium() {
        assertFalse(account.isPremium());//balance =5 000 000 < 10 000 000 nên không phải premium
        assertTrue(account1.isPremium());//balance =10 000 000 nên là premium
        assertTrue(account2.isPremium());//balance =100 000 000 >10 000 000 nên là premium
    }

}