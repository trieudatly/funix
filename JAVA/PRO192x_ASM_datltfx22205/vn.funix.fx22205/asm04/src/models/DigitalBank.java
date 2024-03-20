package models;

import java.util.List;

public class DigitalBank extends Bank {

    public Customer getCustomerById(String customerId) {
        for (Customer customer : getCustomers()
        ) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public List<Customer> getAllCustomer() {
        List<Customer> customers = this.getCustomers();
        return customers;
    }

    public boolean withdraw() {
        DigitalCustomer digitalCustomer = (DigitalCustomer) getCustomerById(User.cccdInput());
        if (digitalCustomer == null) {
            System.out.println("Khong ton tai khach hang nay");
            return false;
        }
        return digitalCustomer.withdraw();
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
}


