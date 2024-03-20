package models;

import java.util.List;

public class DigitalBank extends Bank{

    
    

    public List<Customer> getAllCustomer() {
        List<Customer> customers = this.getCustomers();
        return customers;
    }
    //rút tiền theo customerId
    public boolean withdraw(String customerId) {
        DigitalCustomer digitalCustomer = (DigitalCustomer) getCustomerById(customerId);
        //nếu customer không tồn tại return false
        if (digitalCustomer == null) {
            System.out.println("Khong ton tai khach hang nay");
            return false;
        }
        return digitalCustomer.withdraw();
    }

    public DigitalCustomer getCustomerById(String customerId) {
        for (Customer customer : getCustomers()
        ) {
            if (customer.getCustomerId().equals(customerId)) {
                return (DigitalCustomer) customer;
            }
        }
        return null;
    }
}
