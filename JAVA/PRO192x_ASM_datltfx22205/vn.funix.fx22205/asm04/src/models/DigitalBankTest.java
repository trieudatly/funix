package models;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DigitalBankTest {

    DigitalBank activeBank = new DigitalBank();
    List<Account> accounts = new ArrayList<>();
    Customer customer = new Customer("001215000001", "FUNIX", accounts);

    @Test
    public void getCustomerById() {
        assertNull(activeBank.getCustomerById("001215000001"));//activeBank đang trống chưa có customer
        activeBank.addCustomer(customer);
        assertNull(activeBank.getCustomerById("00121500000"));//customerId không hợp lệ
        assertNull(activeBank.getCustomerById("0012150000011"));//customerId không hợp lệ
        assertNull(activeBank.getCustomerById("00121500000a"));//customerId không hợp lệ
        assertNull(activeBank.getCustomerById("00121500000-"));//customerId không hợp lệ
        assertNull(activeBank.getCustomerById("001215000002"));//customer không tồn tại
        assertEquals("001215000001", activeBank.getCustomerById("001215000001").getCustomerId());//customer có tồn tại
    }
}