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
        assertTrue(DigitalBank.isCustomerExisted(customerList, "001215000001"));//customer có tồn tại trong list
        assertTrue(DigitalBank.isCustomerExisted(customerList, "001215000002"));//customer có tồn tại trong list
        assertFalse(DigitalBank.isCustomerExisted(customerList, "001215000003"));//customer không tồn tại trong list
        assertFalse(DigitalBank.isCustomerExisted(null, "001215000001"));//list null
        assertFalse(DigitalBank.isCustomerExisted(customerList, null));//customer null
        assertFalse(DigitalBank.isCustomerExisted(null, null));//list và customer null
    }

    @Test
    public void getCustomerById() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);
        assertSame(customer1, DigitalBank.getCustomerById(customerList, "001215000001"));//lấy thành công customer trong list
        assertSame(customer2, DigitalBank.getCustomerById(customerList, "001215000002"));//lấy thành công customer trong list
        assertNull(DigitalBank.getCustomerById(customerList, null));//customer null,lấy không thành công, trả về null
        assertNull(DigitalBank.getCustomerById(null, "001215000001"));//List null,lấy không thành công, trả về null
        assertNull(DigitalBank.getCustomerById(null, null));//customer và list null,lấy không thành công, trả về null
    }
}