package model;

import dao.TransactionDao;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Account implements Serializable {
    //Implements Serializable và thuộc tính
    // static final long serialVersionUID để hỗ trợ đọc/ghi object.
    private static final long serialVersionUID = 1L;
    private String accountNumber;
    private double balance;
    //Thêm thuộc tính customerId,
    // để sau khi lưu vào file thì sẽ xác định được account thuộc customer nào.
    private String customerId;

    public Account(String accountNumber, double balance, String customerId) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerId = customerId;
    }

    /**
     * Lấy ra các giao dịch thuộc account này.
     * Phương thức này sẽ lấy ra tất cả các giao dịch
     * và lọc trong danh sách các giao dịch có accountNumber bằng với accountNumber hiện tại.
     */
    public List<Transaction> getTransactions() {
        return TransactionDao.list()
                .stream()
                .filter(transaction -> transaction.getAccountNumber().equals(accountNumber))
                .collect(Collectors.toList());
    }


    /**
     * lấy ra danh sách transaction từ hàm getTransaction rồi hiển thị ra màn hình.
     */
    public void displayTransactionsList() {
        List<Transaction> transactions = getTransactions();
        if (transactions != null && !transactions.isEmpty()) {
            displayTransactionHeader();
            for (Transaction transaction : transactions) {
                System.out.println("|" + transaction.toString());
            }
        }
    }

    //header cho log
    private static void displayTransactionHeader() {
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        System.out.println("| Tai Khoan   | Giao Dich | So Tien            | Thoi Gian");
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
    }

    /**
     * tạo ra thêm một giao dịch cho account và cập nhật số dư tài khoản.
     */
    public boolean createTransaction(String accountNumber, TransactionType type, double amount, boolean status, String dateTime) {
        List<Transaction> transactionFile = TransactionDao.list();
        transactionFile.add(new Transaction(accountNumber, type, amount, status, dateTime));
        return TransactionDao.save(transactionFile);
    }

    //Phương thức input(Scanner scanner) để thêm tài khoản mới vào danh sách.
// Yêu cầu người dùng nhập số tài khoản và số tiền ban đầu.
// Kiểm tra tính hợp lệ của giao dịch ban đầu sau đó gọi hàm createTransaction()
// để tạo ra một giao dịch thêm tiền (DEPOSIT) và thay đổi số dư tài khoản.
    public boolean input(Scanner scanner) {
        return false;
    }

    public boolean isPremium() {
        //1 tài khoản là premium nếu như balance tối thiểu 10_000_000 VNĐ
        if (balance >= 10000000) {
            return true;
        }
        return false;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
