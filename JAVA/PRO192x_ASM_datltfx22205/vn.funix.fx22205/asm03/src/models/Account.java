package models;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private double balance;
    private String accountType;
    private List<Transaction> transactions = new ArrayList<>();

    public Account() {
        accountNumber = accountNumberInput();
        balance = balanceInput();
        this.accountType = accountType;
    }

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        balance = balanceInput();
    }

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Account(String accountNumber, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }

    public static String accountNumberInput() {
        //tạo 1 String với pattern dùng dể so khớp
        // ^ và $ để khai báo bắt đầu và kết thúc 1 pattern
        // \\{6} tức là 6 số bất kì từ 0-9
        final String ACCOUNT_PATTERN = "^\\d{6}$";
        System.out.print("Nhap so ma tai khoan(gom 6 chu so): ");
        return Utility.getInputWithPattern(ACCOUNT_PATTERN);
    }

    public static void displayTransactionHeader() {
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        System.out.println("| Tai Khoan   | Thoi Gian           | Trang Thai       | Ma Giao Dich                         | So Luong");
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
    }

    private double balanceInput() {
        //tạo 1 String với pattern dùng dể so khớp
        // ^ và $ để khai báo bắt đầu và kết thúc 1 pattern
        // ? có hoặc không số bất kì từ 0-9, hoặc dấu .
        final String BALANCE_PATTERN = "^([0-9]*[.])?[0-9]+$";
        while (true) {
            System.out.print("Nhap so du tai khoan: ");
            double balance = Double.parseDouble(Utility.getInputWithPattern(BALANCE_PATTERN));
            // số dư của tài khoản, không được nhỏ hơn 50_000 VNĐ
            if (balance >= 50000) {
                return balance;
            }
            System.out.println("so du phai lon hon hoac bang 50,000VND");
        }
    }

    public boolean isPremium() {
        //1 tài khoản là premium nếu như balance tối thiểu 10_000_000 VNĐ
        if (balance >= 10000000) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        //trả về String thông tin 1 account
        return String.format("%s %-20s %,.0f%s", accountNumber, "|", balance, "đ");
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

    public String getAccountType() {
        if (this instanceof SavingsAccount) {
            return "savings";
        }
        return "loan";
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public void displayAllTransactions() {
        if (getTransactions() != null) {
            ArrayList<Transaction> transactions = new ArrayList<>(getTransactions());

            for (Transaction transaction : transactions) {
                System.out.println("|" + transaction.toString());

            }
            System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        }
    }
}
