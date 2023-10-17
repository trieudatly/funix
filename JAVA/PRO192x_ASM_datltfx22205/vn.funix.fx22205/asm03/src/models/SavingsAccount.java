package models;

public class SavingsAccount extends Account implements Withdraw, ReportService {
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public String toString() {
        return String.format("%s %-20s %,.0f%s", getAccountNumber(), "| SAVINGS | ", getBalance(), "đ");
    }


    @Override
    public boolean withdraw(double amount) {
        if (isAccepted(amount)) {
            double newBalance = getBalance() - amount;
            addTransaction(new Transaction(this.getAccountNumber(), amount, 0, true));
            setBalance(newBalance);
            System.out.println("Giao dich thanh cong");
            //log(amount);
            return true;
        }
        Transaction transaction = new Transaction(this.getAccountNumber(), amount, 0, false);
        addTransaction(transaction);
        System.out.println("Giao dich khong thanh cong");
        return false;
    }

    @Override
    public boolean isAccepted(double amount) {

        if (amount % 10000 != 0) {
            System.out.println("So tien rut phai la boi so cua 10 000");
            return false;
        }
        if (amount < ACCOUNT_MIN_WITHDRAW) {
            System.out.println("So tien rut toi thieu la: " + ACCOUNT_MIN_WITHDRAW);
            return false;
        }
        if (!isPremium() && amount > SAVINGS_ACCOUNT_MAX_WITHDRAW) {
            System.out.println("So tien toi da co the rut: " + SAVINGS_ACCOUNT_MAX_WITHDRAW);
            return false;
        }
        double newBalance = getBalance() - amount;
        if (newBalance < ACCOUNT_MIN_BALANCE) {
            System.out.println("So du hien tai khong du");
            return false;
        }
        return true;
    }

    @Override
    public void log(double amount) {
        System.out.println("+------+-----------------------+------+");
        System.out.println("      BIEN LAI GIAO DICH SAVINGS       ");
        System.out.printf("NGAY G/D: %28s%n", Utility.getDateTime());
        System.out.printf("ATM ID: %30s%n", "DIGITAL-BANK-ATM 2023");
        System.out.printf("SO TK: %31s%n", getAccountNumber());
        System.out.printf("SO TIEN: %29s%n", String.format("%.1f", amount));
        System.out.printf("SO DU: %31s%n", String.format("%.1f", getBalance()));
        System.out.printf("PHI + VAT: %27s%n", String.format("%.1f", 0));
        System.out.println("+------+-----------------------+------+");
    }
}
