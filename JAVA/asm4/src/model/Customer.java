package model;

import exception.CustomerIdNotValidException;
import service.CustomerIdValidator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer implements Serializable {
    //Implements Serializable và thuộc tính
    // static final long serialVersionUID để hỗ trợ đọc/ghi object.
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;

    public Customer(String customerId, String name) throws CustomerIdNotValidException {
        if (!CustomerIdValidator.validateCustomerId(customerId)) {
            throw new CustomerIdNotValidException("ID khong hop le");
        }
        this.id = customerId;
        this.name = name;
    }
//Tạo một hàm khởi tạo Customer(List<String> values) để phục vụ việc đọc dữ liệu từ file text
    public Customer(List<String> values) throws CustomerIdNotValidException {
        this(values.get(0), values.get(1));
    }
//Phương thức getAccounts() lấy ra những account có customerId bằng customerId hiện tại.
// Phương thức này sử dụng stream.filter để lọc từ danh sách account lấy từ file.
    public List<Account> getAccounts() {
        return null;
    }
//Phương thức displayInformation() Hiển thị thông tin của customer,
// thông tin các tài khoản của customer (lấy tài khoản từ phương thức getAccounts).
    public void displayInformation() {

    }
//Phương thức getAccountByAccountNumber(List<Account> accounts, String accountNumber)
// lấy ra account từ trong danh sách.
    public Account getAccountByAccountNumber(List<Account> accounts, String accountNumber) {
        return null;
    }
//Phương thức displayTransactionInformation() hiển thị thông tin customer,
// thông tin các tài khoản và thông tin các giao dịch của khách hàng hiện tại.
    public void displayTransactionInformation() {

    }
//Phương thức withdraw(Scanner scanner) yêu cầu nhập số tài khoản
// (lấy danh sách accounts từ getAccounts() để kiểm tra xem tài khoản có tồn tại hay không),
// nhập số tiền rút sau đó gọi hàm rút tiền của account.
    public boolean withdraw(Scanner scanner) {
        List<Account> accounts = getAccounts();
        if (!accounts.isEmpty()) {
            Account account;
            double amount;
            do {
                System.out.println("Nhap so tai khoan: ");
                account = getAccountByAccountNumber(accounts, scanner.nextLine());
            } while (account == null);
            do {
                System.out.println("Nhap so tien rut: ");
                amount = Double.parseDouble(scanner.nextLine());
            } while (amount <= 0);
            if (account instanceof SavingAccount) {
                ((SavingAccount) account).withdraw(amount);
                return true;
            } else {
                System.out.println("Khach hang khong co tai khoan nao, thao tac khong thanh cong");
            }
        }
        return false;
    }

    //Phương thức tranfers(Scanner scanner) yêu cầu nhập tài khoản dùng để chuyển tiền,
    // nhập tài khoản nhận tiền (kiểm tra tính hợp lệ của từng tài khoản),
    // sau đó yêu cầu nhập số tiền rút,
    // xác nhận việc chuyển tiền và sau khi thỏa mãn hết các điều kiện
    // sẽ gọi hàm transfer của account gửi.
    public boolean tranfers(Scanner scanner) {
        return false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
