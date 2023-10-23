package models;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Account {
    private String accountNumber;
    private double balance;

    private List<Transaction> transactions = new ArrayList<>();

    public Account() {
        accountNumber = accountNumberInput();
        balance = amountInput();

    }

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        balance = amountInput();
    }

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public static String accountNumberInput() {
        //tạo 1 String với pattern dùng dể so khớp
        // ^ và $ để khai báo bắt đầu và kết thúc 1 pattern
        // \\{6} tức là 6 số bất kì từ 0-9
        final String ACCOUNT_PATTERN = "^\\d{6}$";
        System.out.print("Nhap so ma tai khoan(gom 6 chu so): ");
        return Utility.getInputWithPattern(ACCOUNT_PATTERN);
    }

    public static double amountInput() {
        //tạo 1 String với pattern dùng dể so khớp
        // ^ và $ để khai báo bắt đầu và kết thúc 1 pattern
        // ? có hoặc không số bất kì từ 0-9, hoặc dấu .
        final String AMOUNT_PATTERN = "^([0-9]*[.])?[0-9]+$";
        while (true) {
            System.out.print("Nhap so tien: ");
            double amount = Double.parseDouble(Utility.getInputWithPattern(AMOUNT_PATTERN));
            // số dư của tài khoản, không được nhỏ hơn 50_000 VNĐ
            if (amount >= 50000 && amount % 10000 == 0) {
                return amount;
            }
            System.out.println("so tien phai lon hon hoac bang 50,000 va la boi so cua 10 000");
        }
    }

    boolean validateAccount(String accountNumber) {
        final String ACCOUNT_PATTERN = "^\\d{6}$";
        return Pattern.matches(ACCOUNT_PATTERN, accountNumber);
    }

    public boolean isAccountPremium() {
        //1 tài khoản là premium nếu như balance tối thiểu 10_000_000 VNĐ
        if (balance >= 10000000) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        //trả về String thông tin 1 account
        return String.format("%s %-20s %,.0f%s", accountNumber, "|", balance, " đ");
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
        if (this instanceof LoanAccount) {
            return "loan";
        }
        return "savings";
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public void displayAllTransactions() {
        List<Transaction> transactions = new ArrayList<>(getTransactions());
        if (!transactions.isEmpty()) {
            for (Transaction transaction : transactions) {
                System.out.println("|" + transaction.toString());
            }
        }
    }
}
