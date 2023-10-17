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
        //nếu phương thức isCustomerExisted trả về true
        //thông báo đã tồn tại customer này trong bank
        if (isCustomerExisted(newCustomer.getCustomerId())) {
            System.out.println("ID " + newCustomer.getCustomerId() + " da ton tai");
        } else {
            //nếu customer chưa tồn tại
            //thêm newCustomer vào list customers
            customers.add(newCustomer);
            //thông báo thành công
            System.out.println("da them khach hang " + newCustomer.getCustomerId() + " vao danh sach");
        }
    }

    public void addNewCustomer(String customerId, String name) {
        customers.add(new Customer(customerId, name));
    }

    public void addAccount(String CCCD, Account account) {
        for (int i = 0; i < customers.size(); i++) {
            if (CCCD.equals(customers.get(i).getCustomerId())) {
                customers.get(i).addAccount(account);
                return;
            }
        }
        System.out.println("Khach hang khong ton tai");
    }

    public boolean isCustomerExisted(String customerId) {
        //nếu list trống thì coi như customer không tồn tại
        if (customers.isEmpty()) {
            return false;
        }
        //duyệt List customers
        for (Customer cus : customers
        ) {
            //nếu trong list tồn tại đối tượng Customer có ID bằng customerId
            //=> trả về true
            if (customerId.equals(cus.getCustomerId())) {
                return true;
            }
        }
        //còn lại trả về false
        return false;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public String getId() {
        return id;
    }
}
