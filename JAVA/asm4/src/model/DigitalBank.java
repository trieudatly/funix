package model;

import dao.AccountDao;
import dao.CustomerDao;
import exception.CustomerIdNotValidException;
import file.TextFileService;
import service.Validator;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

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
            System.out.println("Khong tim thay khach hang");
        }
    }

    public void showTransactions() {
        //nhập id khách hàng
        String id = Validator.customerIdInput();
        if (!id.equals("exit")) {
            //nếu khách hàng tồn tại => thêm tài khoản mới vào khách hàng cụ thể
            if (isCustomerExisted(id)) {
                for (Customer customer : customers) {
                    if (id.equals(customer.getId())) {
                        customer.displayTransaction();
                    }
                }
            } else {
                System.out.println("Chua co khach hang nao trong danh sach");
            }
        }
    }
    //Phương thức addCustomers(fileName) sẽ đọc dữ liệu từ file,
// dữ liệu từ file bao gồm nhiều khách hàng,
// kiểm tra dữ liệu từng khách hàng có số ID hợp lệ hay không,
// nếu hợp lệ thì thêm vào danh sách,
// nếu không hợp lệ hoặc số ID đã tồn tại thì hiển thị đoạn thông báo.
// Sau đó lưu dữ liệu customer vào file.

    public boolean addCustomers(String fileName) {
        customers = CustomerDao.list();
        List<List<String>> txtCustomer;
        try {
            txtCustomer = TextFileService.readFile(fileName);
        } catch (FileNotFoundException e) {
            return false;
        }
        if (!txtCustomer.isEmpty()) {
            for (List<String> list : txtCustomer
            ) {
                try {
                    Customer customer = new Customer(list);
                    addCustomer(customer);
                } catch (CustomerIdNotValidException e) {
                    System.out.println(e.getMessage());
                }
            }
            return true;
        } else {
            System.out.println("Loi doc file");
            return false;
        }
    }

    public boolean addCustomer(Customer newCustomer) {
        //nếu phương thức isCustomerExisted trả về true
        //thông báo đã tồn tại customer này trong bank
        if (isCustomerExisted(newCustomer.getId())) {
            System.out.println("Them khach hang " + newCustomer.getId() + "  khong thanh cong");
            return false;
        } else {
            //nếu customer chưa tồn tại
            //thêm newCustomer vào list customers
            customers.add(newCustomer);
            CustomerDao.save(customers);
            System.out.println("Them khach hang " + newCustomer.getId() + "  thanh cong");
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
        if (id.equals("exit")) {
            return false;
        }
        List<Account> accounts = AccountDao.list();
        //nếu khách hàng tồn tại => thêm tài khoản mới vào khách hàng cụ thể
        if (isCustomerExisted(id)) {
            String accountNumber = Validator.accountInput();
            if (accountNumber.equals("exit")) {
                return false;
            }
            SavingAccount savingsAccount = new SavingAccount(accountNumber, Validator.amountInput(), id);
            for (Customer customer : customers) {
                if (id.equals(customer.getId())) {
                    if (!customer.addAccount(savingsAccount)) {
                        return false;
                    } else {
                        accounts.add(savingsAccount);
                        AccountDao.save(accounts);
                        System.out.println("Them tai khoan thanh cong");
                        return true;
                    }
                }
            }
        }
        //nếu khách hàng không tồn tại=>thông báo
        System.out.println("Khong tim thay khach hang " + id);
        return false;

    }

    //Phương thức withdraw(Scanner scanner, String customerId) để rút tiền.
// Phương thức này cần kiểm tra customerId hợp lệ,
// sau đó hiển thị các thông tin tài khoản của khách hàng
// rồi gọi đến phương thức rút tiền của đối tượng customer.
    public boolean withdraw() {
        //nhập id khách hàng
        String id = Validator.customerIdInput();
        if (id.equals("exit")) {
            return false;
        }
        if (isCustomerExisted(id)) {
            for (Customer customer : customers) {
                if (id.equals(customer.getId())) {
                    return customer.withdraw();
                }
            }
        }
        System.out.println("Khach hang khong ton tai");
        return false;
    }

    //Phương thức tranfers(Scanner scanner, String customerId) để chuyển tiền giữa 2 tài khoản.
// Phương thức này cần kiểm tra customerId hợp lệ,
// sau đó hiển thị các thông tin tài khoản của khách hàng
// rồi gọi đến phương thức chuyển tiền của đối tượng customer.
    public boolean tranfer() {
        //nhập id khách hàng
        String id = Validator.customerIdInput();
        if (id.equals("exit")) {
            return false;
        }
        if (isCustomerExisted(id)) {
            for (Customer customer : customers) {
                if (id.equals(customer.getId())) {
                    return customer.tranfers();
                }
            }
        }
        System.out.println("Khach hang khong ton tai");
        return false;
    }


    /**
     * Phương thức isCustomerExisted( Customer newCustomer)
     * kiểm tra một customer có tồn tại trong mảng hay không.
     */
    public boolean isCustomerExisted(String id) {
        customers = CustomerDao.list();
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