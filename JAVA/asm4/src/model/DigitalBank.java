package model;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class DigitalBank extends Bank {
    //Phương thức showCustomers() sẽ đọc dữ liệu từ file sử dụng hàm CustomerDao.list()
    // để lấy danh sách khách hàng và hiển thị thông qua hàm displayInformation.
    // Nếu không có khách hàng nào trong danh sách
    // thì hiển thị “Chưa có khách hàng nào trong danh sách!”.
    public void showCustomers() {

    }
//Phương thức addCustomers(fileName) sẽ đọc dữ liệu từ file,
// dữ liệu từ file bao gồm nhiều khách hàng,
// kiểm tra dữ liệu từng khách hàng có số ID hợp lệ hay không,
// nếu hợp lệ thì thêm vào danh sách,
// nếu không hợp lệ hoặc số ID đã tồn tại thì hiển thị đoạn thông báo.
// Sau đó lưu dữ liệu customer vào file.
    public boolean addCustomers(String fileName) {
        return false;
    }
//Phương thức addSavingAccount(Scanner scanner, String customerId)
// để tạo mới một tài khoản ATM cho một khách hàng và lưu tài khoản vào file.
// Phương thức này cần kiểm tra customerId hợp lệ,
// sau đó gọi phương thức thêm tài khoản mới của đối tượng customer.
    public boolean addSavingAccount(Scanner scanner, String customerId) {
        return false;
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
//Phương thức isCustomerExisted(List<Customer> customers, Customer newCustomer)
// kiểm tra một customer có tồn tại trong mảng hay không.
    public boolean isCustomerExisted(List<Customer> customers, Customer newCustomer) {
        return false;
    }
//Phương thức getCustomerById(List<Customer> customerList, String customerId)
// lấy ra một customer có id bằng id cho trước.
    public Customer getCustomerById(List<Customer> customerList, String customerId) {
        return null;
    }

}