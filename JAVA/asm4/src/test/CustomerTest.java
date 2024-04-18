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
        assertTrue(Customer.isAccountExisted(accountList, "123456"));
        assertTrue(Customer.isAccountExisted(accountList, "123546"));
        assertTrue(Customer.isAccountExisted(accountList, "654321"));
        assertFalse(Customer.isAccountExisted(accountList, "098765"));
        assertFalse(Customer.isAccountExisted(null, "654321"));
        assertFalse(Customer.isAccountExisted(accountList, null));
        assertFalse(Customer.isAccountExisted(null, null));
    }

    @Test
    public void getAccountByAccountNumber() {
        List<Account> accountList = new ArrayList<>();
        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);
        assertSame(account1, Customer.getAccountByAccountNumber(accountList, "123456"));
        assertSame(account2, Customer.getAccountByAccountNumber(accountList, "123546"));
        assertSame(account3, Customer.getAccountByAccountNumber(accountList, "654321"));
        assertNull(Customer.getAccountByAccountNumber(accountList, null));
        assertNull(Customer.getAccountByAccountNumber(null, "654321"));
        assertNull(Customer.getAccountByAccountNumber(null, null));
    }

    @Test
    public void isPremium() {
        List<Account> accountList1 = new ArrayList<>();
        accountList1.add(account1);
        customer1.setAccounts(accountList1);
        List<Account> accountList2 = new ArrayList<>();
        accountList2.add(account2);
        customer2.setAccounts(accountList2);
        assertFalse(customer1.isPremium());
        assertTrue(customer2.isPremium());
    }
}