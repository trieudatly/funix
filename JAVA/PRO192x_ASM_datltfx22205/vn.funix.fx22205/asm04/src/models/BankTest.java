package models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BankTest {
    Bank bank = new Bank();
    List<Account> accounts = new ArrayList<>();
    Customer customer = new Customer("001215000001", "FUNIX", accounts);
    Customer customer1 = new Customer("001215000002", "FUNNY", accounts);


    @Test
    public void isCustomerExisted() {
        assertFalse(bank.isCustomerExisted("001215000001"));//bank trống chưa có customer nào
        bank.addCustomer(customer);
        bank.addCustomer(customer1);
        assertFalse(bank.isCustomerExisted("001215000003"));//không có customer này trong bank
        assertTrue(bank.isCustomerExisted("001215000001"));//customer tồn tại trong bank
        assertTrue(bank.isCustomerExisted("001215000002"));//customer tồn tại trong bank
    }
}