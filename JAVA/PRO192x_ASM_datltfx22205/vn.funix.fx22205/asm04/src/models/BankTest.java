package models;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BankTest {
    Bank bank = new Bank();
    Customer customer = new Customer("001215000001", "FUNIX");
    Customer customer1 = new Customer("001215000002", "FUNNY");


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