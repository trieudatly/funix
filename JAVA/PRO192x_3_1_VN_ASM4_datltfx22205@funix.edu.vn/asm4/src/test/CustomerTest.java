package test;

import exception.CustomerIdNotValidException;
import model.Account;
import model.Customer;
import model.SavingAccount;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerTest {
    SavingAccount account1 = new SavingAccount("123456", 5000000, "001215000001");
    SavingAccount account2 = new SavingAccount("123546", 10000000, "001215000001");
    SavingAccount account3 = new SavingAccount("654321", 100000000, "001215000001");


    Customer customer1;
    Customer customer2;

    {
        try {
            customer1 = new Customer("001215000001", "TEST CUSTOMER 1");
        } catch (CustomerIdNotValidException e) {
            throw new RuntimeException(e);
        }
    }

    {
        try {
            customer2 = new Customer("001215000002", "TEST CUSTOMER 2");
        } catch (CustomerIdNotValidException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void isAccountExisted() {
        List<Account> accountList = new ArrayList<>();
        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);
        assertTrue(Customer.isAccountExisted(accountList, "123456"));//account có tồn tại trong list
        assertTrue(Customer.isAccountExisted(accountList, "123546"));//account có tồn tại trong list
        assertTrue(Customer.isAccountExisted(accountList, "654321"));//account có tồn tại trong list
        assertFalse(Customer.isAccountExisted(accountList, "098765"));//account không tồn tại trong list
        assertFalse(Customer.isAccountExisted(null, "654321"));// list null
        assertFalse(Customer.isAccountExisted(accountList, null));//account null
        assertFalse(Customer.isAccountExisted(null, null));//account và list đều null
    }

    @Test
    public void getAccountByAccountNumber() {
        List<Account> accountList = new ArrayList<>();
        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);
        assertSame(account1, Customer.getAccountByAccountNumber(accountList, "123456"));//lấy thành công account trong list
        assertSame(account2, Customer.getAccountByAccountNumber(accountList, "123546"));//lấy thành công account trong list
        assertSame(account3, Customer.getAccountByAccountNumber(accountList, "654321"));//lấy thành công account trong list
        assertNull(Customer.getAccountByAccountNumber(accountList, null));//account = null,không lấy được account trong list, trả về null
        assertNull(Customer.getAccountByAccountNumber(null, "654321"));//list = null,không lấy được account trong list, trả về null
        assertNull(Customer.getAccountByAccountNumber(null, null));//account và list null,không lấy được account trong list, trả về null
    }

    @Test
    public void isPremium() {
        List<Account> accountList1 = new ArrayList<>();
        accountList1.add(account1);
        customer1.setAccounts(accountList1);
        List<Account> accountList2 = new ArrayList<>();
        accountList2.add(account2);
        customer2.setAccounts(accountList2);
        assertFalse(customer1.isPremium());//account1 có số dư 5 000 000 <10 000 000 nên customer1 không phải premium
        assertTrue(customer2.isPremium());//account2 có số dư 10 000 000 = 10 000 000 nên customer2 là premium
    }
}