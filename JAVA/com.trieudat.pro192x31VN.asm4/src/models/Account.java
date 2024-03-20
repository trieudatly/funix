package models;

import utility.Validation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    public Account() {

    }
    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }



    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }



    public static String accountNumberInput() {
        //tạo 1 String với pattern dùng dể so khớp
        // ^ và $ để khai báo bắt đầu và kết thúc 1 pattern
        // \\{6} tức là 6 số bất kì từ 0-9
        final String ACCOUNT_PATTERN = "^\\d{6}$";
        System.out.print("Nhap so ma tai khoan(gom 6 chu so): ");
        return Validation.getInputWithPattern(ACCOUNT_PATTERN);
    }

    public static double amountInput() {
        //tạo 1 String với pattern dùng dể so khớp
        // ^ và $ để khai báo bắt đầu và kết thúc 1 pattern
        // ? có hoặc không số bất kì từ 0-9, hoặc dấu .
        final String AMOUNT_PATTERN = "^([0-9]*[.])?[0-9]+$";
        while (true) {
            System.out.print("Nhap so tien: ");
            double amount = Double.parseDouble(Validation.getInputWithPattern(AMOUNT_PATTERN));
            // số dư của tài khoản, không được nhỏ hơn 50_000 VNĐ
            if (amount >= 50000 && amount % 10000 == 0) {
                return amount;
            }
            System.out.println("so tien phai lon hon hoac bang 50,000 va la boi so cua 10 000");
        }
    }

    @Override
    public String toString() {
        //trả về String thông tin 1 account
        return String.format("%s %-20s %,.0f%s", accountNumber, "|", balance, " đ");
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public void displayAllTransactions() {
        List<Transaction> transactions;
        transactions = new ArrayList<>(getTransactions());
        if (!transactions.isEmpty()) {
            for (Transaction transaction : transactions) {
                System.out.println("|" + transaction.toString());
            }
        }
    }

    public String getAccountType() {
        if (this instanceof LoanAccount) {
            return "loan";
        }
        return "savings";
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

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
