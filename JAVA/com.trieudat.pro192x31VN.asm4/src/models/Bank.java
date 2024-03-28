package models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Bank {
    private String id;
    private String name;
    private List<Customer> customers;

    public Bank(String id, List<Customer> customers) {
        this.id = id;
        this.customers = customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Bank() {
        this.customers = new ArrayList<>();
        this.id = String.valueOf(UUID.randomUUID());
    }

    public boolean isCustomerExisted(String customerId) {
        //nếu list trống thì coi như customer không tồn tại
        if (customers.isEmpty()) {
            return false;
        }
        //duyệt List customers
        for (Customer customer : customers
        ) {
            //nếu trong list tồn tại đối tượng Customer có ID bằng customerId
            //=> trả về true
            if (customerId.equals(customer.getCustomerId())) {
                return true;
            }
        }
        //còn lại trả về false
        return false;
    }

    public boolean addCustomer(Customer newCustomer) {
        //nếu phương thức isCustomerExisted trả về true
        //thông báo đã tồn tại customer này trong bank
        if (isCustomerExisted(newCustomer.getCustomerId())) {
            System.out.println("Khach hang " + newCustomer.getCustomerId() + " da ton tai, them khach hang khong thanh cong");
            return false;
        } else {
            //nếu customer chưa tồn tại
            //thêm newCustomer vào list customers
            customers.add(newCustomer);
            System.out.println("Da them khach hang " + newCustomer.getCustomerId() + " vao danh sach khach hang");
            return true;
        }
    }

    public void addAccount(String customerId, Account account) {
        for (int i = 0; i < customers.size(); i++) {
            if (customerId.equals(customers.get(i).getCustomerId())) {
                customers.get(i).addAccount(account);
                return;
            }
        }
        System.out.println("Khach hang khong ton tai");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
