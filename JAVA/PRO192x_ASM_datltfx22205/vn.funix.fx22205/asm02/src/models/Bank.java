package models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bank {
    private String id;
    private List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
        this.id = String.valueOf(UUID.randomUUID());
    }

    public void addCustomer(Customer newCustomer) {
        int cusCheck = 0;
        for (Customer cus : customers
        ) {
            if (newCustomer.getCustomerId().equals(cus.getCustomerId())) {
                cusCheck++;
                break;
            }
        }
        if (cusCheck == 0) {
            customers.add(newCustomer);
            System.out.println("da them khach hang " + newCustomer.getCustomerId() + " vao danh sach");
        } else {
            System.out.println("ID " + newCustomer.getCustomerId() + " da ton tai");
        }

    }

    public void addAccount(String customerId, Account account) {

    }

    public boolean isCustomerExisted(String customerId) {
        return false;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public String getId() {
        return id;
    }


}
