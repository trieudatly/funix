package models;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AccountTest {
    Account account = new Account("123456", 5000000);
    Account account1 = new Account("123456", 10000000);
    Account account2 = new Account("123456", 100000000);

    @Test
    public void validateAccount() {
        //account hợp lệ có 6 số bất kì từ 0-9
        assertFalse(account.validateAccount("12345"));//thiếu số
        assertFalse(account.validateAccount("1234567"));//thừa số
        assertFalse(account.validateAccount("12345a"));//có chữ
        assertFalse(account.validateAccount("12345-"));//có ký tự đặc biệt
        assertTrue(account.validateAccount("123456"));//hợp lệ
    }

    @Test
    public void isAccountPremium() {
        //account là premium khi có balance >=10 000 000
        assertFalse(account.isAccountPremium());//balance =5 000 000 < 10 000 000 nên không phải premium
        assertTrue(account1.isAccountPremium());//balance =10 000 000 nên là premium
        assertTrue(account2.isAccountPremium());//balance =100 000 000 >10 000 000 nên là premium
    }
}