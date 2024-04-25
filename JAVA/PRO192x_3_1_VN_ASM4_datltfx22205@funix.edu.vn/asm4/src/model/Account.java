package model;

import dao.TransactionDao;

import java.io.Serializable;
import java.util.List;
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

    /**
     * header cho log
     */
    private static void displayTransactionHeader() {
        System.out.println("+-------------------------------------------------------------------+");
        System.out.println("| Tai Khoan   | Giao Dich | So Tien            | Thoi Gian");
        System.out.println("+-------------------------------------------------------------------+");
    }

    /**
     * tạo ra thêm một giao dịch cho account và lưu vào file.
     */
    public boolean createTransaction(String accountNumber, TransactionType type, double amount, boolean status, String dateTime) {
        List<Transaction> transactionFile = TransactionDao.list();
        transactionFile.add(new Transaction(accountNumber, type, amount, status, dateTime));
        return TransactionDao.save(transactionFile);
    }

    /**
     * Kiểm tra account có phải loại Premium không
     * 1 account là premium nếu như balance tối thiểu 10_000_000 VNĐ
     */
    public boolean isPremium() {
        if (balance >= 10_000_000) {
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
