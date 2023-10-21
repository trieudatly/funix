package models;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CustomerTest {
    Customer customer = new Customer("001215000001", "FUNIX");
    SavingsAccount saving1 = new SavingsAccount("123456", 5000000);
    SavingsAccount saving2 = new SavingsAccount("234567", 10000000);
    LoanAccount loan1 = new LoanAccount("987654");

    @Test
    public void isCustomerPremium() {
        //Customer là premium khi có ít nhất
        // 1 tài khoản saving là premium
        customer.addAccount(saving1);
        assertFalse(customer.isCustomerPremium());//saving1 có balance 5 000 000 < 10 000 000
        customer.addAccount(loan1);
        assertFalse(customer.isCustomerPremium());//tài khoản loan không ảnh hưởng tới customer có premium hay không
        customer.addAccount(saving2);
        assertTrue(customer.isCustomerPremium());
        //saving2 có balance 10 000 000 = 10 000 000 là tài khoản premium
        // nên customer cũng là premium
    }

    @Test
    public void getAccountByAccountNumber() {
    }

    @Test
    public void isAccountExisted() {
    }

    @Test
    public void getTotalAccountBalance() {
    }
}