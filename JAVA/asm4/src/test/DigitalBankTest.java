package test;

import exception.CustomerIdNotValidException;
import model.Customer;
import model.DigitalBank;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DigitalBankTest {
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
    public void isCustomerExisted() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);
        assertTrue(DigitalBank.isCustomerExisted(customerList, "001215000001"));
        assertTrue(DigitalBank.isCustomerExisted(customerList, "001215000002"));
        assertFalse(DigitalBank.isCustomerExisted(customerList, "001215000003"));
        assertFalse(DigitalBank.isCustomerExisted(null, "001215000001"));
        assertFalse(DigitalBank.isCustomerExisted(customerList, null));
        assertFalse(DigitalBank.isCustomerExisted(null, null));
    }

    @Test
    public void getCustomerById() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);
        assertSame(customer1, DigitalBank.getCustomerById(customerList, "001215000001"));
        assertSame(customer2, DigitalBank.getCustomerById(customerList, "001215000002"));
        assertNull(DigitalBank.getCustomerById(customerList, null));
        assertNull(DigitalBank.getCustomerById(null, "001215000001"));
        assertNull(DigitalBank.getCustomerById(null, null));
    }
}