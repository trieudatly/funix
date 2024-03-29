package models;

import dao.CustomerDao;
import file.TextFileService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class DigitalBank extends Bank {

    public List<Customer> getCustomerFromFile() {
        this.setCustomers(CustomerDao.list());
        return this.getCustomers();
    }

    public void addCustomersFromTextFile(String fileName) {
        this.setCustomers(getCustomerFromFile());
        List<Customer> txtCustomer = TextFileService.readFile(fileName);
        if (txtCustomer != null && !txtCustomer.isEmpty()) {
            for (Customer cus : txtCustomer
            ) {
                addCustomer(cus);
            }
        }
        try {
            CustomerDao.save(this.getCustomers());
        } catch (IOException e) {
            System.out.println("Loi ghi file" + e.getMessage());
        }
    }

    public void addSavingAccount(Scanner scanner, String customerId) {

    }

    public void withdraw(Scanner scanner, String customerId) {

    }

    public void tranfers(Scanner scanner, String customerId) {

    }

    public boolean isAccountExisted(List<Account> accountsList, Account newAccount) {
        return false;
    }

    public boolean isCustomerExisted(List<Customer> customers, Customer newCustomer) {
        return false;
    }

    public List<Customer> getAllCustomer() {
        return this.getCustomers();
    }

    public Customer getCustomerById(List<Customer> customerList, String customerId) {
        return null;
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
