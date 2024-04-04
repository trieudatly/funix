package model;

import dao.CustomerDao;
import exception.CustomerIdNotValidException;
import file.TextFileService;
import service.Validator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DigitalBank extends Bank {
    private List<Customer> customers = new ArrayList<>();

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    //Phương thức showCustomers() sẽ đọc dữ liệu từ file sử dụng hàm CustomerDao.list()
    // để lấy danh sách khách hàng và hiển thị thông qua hàm displayInformation.
    // Nếu không có khách hàng nào trong danh sách
    // thì hiển thị “Chưa có khách hàng nào trong danh sách!”.
    public void showCustomers() {
        customers = CustomerDao.list();
        if (!customers.isEmpty()) {
            for (Customer customer : customers
            ) {
                customer.displayInformation();
            }
        } else {
            System.out.println("Chua co khach hang nao trong danh sach");
        }
    }

    //Phương thức addCustomers(fileName) sẽ đọc dữ liệu từ file,
// dữ liệu từ file bao gồm nhiều khách hàng,
// kiểm tra dữ liệu từng khách hàng có số ID hợp lệ hay không,
// nếu hợp lệ thì thêm vào danh sách,
// nếu không hợp lệ hoặc số ID đã tồn tại thì hiển thị đoạn thông báo.
// Sau đó lưu dữ liệu customer vào file.
    public void addCustomers(String fileName) {
        customers = CustomerDao.list();
        List<List<String>> txtCustomer = TextFileService.readFile(fileName);
        if (txtCustomer != null && !txtCustomer.isEmpty()) {
            for (List<String> list : txtCustomer
            ) {
                try {
                    Customer customer = new Customer(list);
                    addCustomer(customer);
                } catch (IndexOutOfBoundsException | CustomerIdNotValidException e) {
                    System.out.println(e.getMessage());
                }
            }
        } else {
            System.out.println("Loi doc file");
        }
        try {
            CustomerDao.save(this.getCustomers());
        } catch (IOException e) {
            System.out.println("Loi ghi file" + e.getMessage());
        }

    }

    public boolean addCustomer(Customer newCustomer) {
        //nếu phương thức isCustomerExisted trả về true
        //thông báo đã tồn tại customer này trong bank
        if (isCustomerExisted(newCustomer.getId())) {
            System.out.println("Khach hang " + newCustomer.getId() + " da ton tai, them khach hang khong thanh cong");
            return false;
        } else {
            //nếu customer chưa tồn tại
            //thêm newCustomer vào list customers
            this.customers.add(newCustomer);
            System.out.println("Da them khach hang " + newCustomer.getId() + " vao danh sach khach hang");
            return true;
        }
    }

    //Phương thức addSavingAccount(Scanner scanner, String customerId)
// để tạo mới một tài khoản ATM cho một khách hàng và lưu tài khoản vào file.
// Phương thức này cần kiểm tra customerId hợp lệ,
// sau đó gọi phương thức thêm tài khoản mới của đối tượng customer.
    public boolean addSavingAccount() {
        //nhập id khách hàng
        String id = Validator.customerIdInput();
        //nếu khách hàng tồn tại => thêm tài khoản mới vào khách hàng cụ thể
        if (isCustomerExisted(id)) {
            SavingAccount savingsAccount = new SavingAccount(Validator.accountInput(), Validator.amountInput(), id);
            for (int i = 0; i < customers.size(); i++) {
                if (id.equals(customers.get(i).getId())) {
                    if (customers.get(i).addAccount(savingsAccount)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } else {
            //nếu khách hàng không tồn tại=>thông báo
            System.out.println("Khach hang khong ton tai");
            return false;
        }

    }

    //Phương thức withdraw(Scanner scanner, String customerId) để rút tiền.
// Phương thức này cần kiểm tra customerId hợp lệ,
// sau đó hiển thị các thông tin tài khoản của khách hàng
// rồi gọi đến phương thức rút tiền của đối tượng customer.
    public boolean withdraw(Scanner scanner, String customerId) {
        return false;
    }

    //Phương thức tranfers(Scanner scanner, String customerId) để chuyển tiền giữa 2 tài khoản.
// Phương thức này cần kiểm tra customerId hợp lệ,
// sau đó hiển thị các thông tin tài khoản của khách hàng
// rồi gọi đến phương thức chuyển tiền của đối tượng customer.
    public boolean tranfers(Scanner scanner, String customerId) {
        return false;
    }

    //Phương thức isAccountExisted(List<Account> accountsList, Account newAccount)
// kiểm tra một account đã tồn tại trong mảng không.
    public boolean isAccountExisted(List<Account> accountsList, Account newAccount) {
        return false;
    }

    //Phương thức isCustomerExisted( Customer newCustomer)
// kiểm tra một customer có tồn tại trong mảng hay không.
    public boolean isCustomerExisted(String id) {
        //nếu list trống thì coi như customer không tồn tại
        if (customers.isEmpty()) {
            return false;
        }
        //duyệt List customers
        for (Customer customer : customers
        ) {
            //nếu trong list tồn tại đối tượng Customer có ID bằng customerId
            //=> trả về true
            if (id.equals(customer.getId())) {
                return true;
            }
        }
        //còn lại trả về false
        return false;
    }

    //Phương thức getCustomerById(List<Customer> customerList, String customerId)
// lấy ra một customer có id bằng id cho trước.
    public Customer getCustomerById(List<Customer> customerList, String customerId) {
        return null;
    }

}