package models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class CustomerTest {
    List<Account> accounts = new ArrayList<>();
    Customer customer = new Customer("001215000001", "FUNIX", accounts);
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
        assertNull(customer.getAccountByAccountNumber("123456"));//customer đang trống chưa có tài khoản
        customer.addAccount(saving1);
        customer.addAccount(loan1);
        assertNull(customer.getAccountByAccountNumber("12345"));//AccountNumber không hợp lệ, không đủ số
        assertNull(customer.getAccountByAccountNumber("9876543"));//AccountNumber không hợp lệ, thừa 1 số
        assertNull(customer.getAccountByAccountNumber("12345-"));//AccountNumber không hợp lệ, có ký tự không phải số
        assertNull(customer.getAccountByAccountNumber("12345a"));//AccountNumber không hợp lệ, có chữ
        //AccountNumber hợp lệ, nhưng không tồn tại account với AccountNumber tương ứng với giá trị mong đợi
        assertNull(customer.getAccountByAccountNumber("123455"));
        assertNull(customer.getAccountByAccountNumber("987656"));
        //AccountNumber hợp lệ, có tồn tại account với AccountNumber tương ứng với giá trị mong đợi
        assertEquals("123456", customer.getAccountByAccountNumber("123456").getAccountNumber());
        assertEquals("987654", customer.getAccountByAccountNumber("987654").getAccountNumber());
    }

    @Test
    public void isAccountExisted() {
        assertFalse(customer.isAccountExisted("123456"));//customer đang trống chưa có tài khoản
        customer.addAccount(saving1);
        assertFalse(customer.isAccountExisted("12345"));//AccountNumber không hợp lệ
        assertFalse(customer.isAccountExisted("1234567"));//AccountNumber không hợp lệ
        assertFalse(customer.isAccountExisted("12345-"));//AccountNumber không hợp lệ
        assertFalse(customer.isAccountExisted("12345a"));//AccountNumber không hợp lệ
        assertFalse(customer.isAccountExisted("123458"));//customer không tồn tại tài khoản này
        assertTrue(customer.isAccountExisted("123456"));//customer có tồn tại tài khoản này
    }

    @Test
    public void getTotalAccountBalance() {
        assertEquals(0, customer.getTotalAccountBalance(), 0.1);//customer đang trống chưa có tài khoản
        customer.addAccount(saving1);
        assertEquals(5000000, customer.getTotalAccountBalance(), 0.1);//account1 có balance 5 000 000
        customer.addAccount(saving2);
        assertEquals(15000000, customer.getTotalAccountBalance(), 0.1);//account1+acount2 = 15 000 000
        customer.addAccount(loan1);
        assertEquals(115000000, customer.getTotalAccountBalance(), 0.1);// account1+acount2+loan1 = 115 000 000
    }
}