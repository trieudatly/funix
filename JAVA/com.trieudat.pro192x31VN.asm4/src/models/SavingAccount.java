package models;

import utility.Utility;

import java.io.Serializable;

public class SavingAccount extends Account implements Withdraw, ReportService, Serializable {
    public SavingAccount() {
    }
    public SavingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public double getFee(double amount, boolean isPremium) {
        //tùy theo tài khoản premium hoặc normal tính mức phí tương ứng
        if (isPremium) {
            return SAVINGS_ACCOUNT_WITHDRAW_PREMIUM_FEE * amount;
        } else {
            return SAVINGS_ACCOUNT_WITHDRAW_FEE * amount;
        }
    }

    @Override
    public boolean withdraw(double amount, boolean isPremium) {
        String dateTime = Utility.getDateTime();
        String accountNumber = this.getAccountNumber();
        //nếu khoản rút được chấp nhận
        //tính toán balance còn lại sau khi rút
        //tạo một transaction mới với thông tin giao dịch thành công
        //dùng log để hiện thông tin giao dịch
        if (isAccepted(amount, isPremium)) {
            double fee = getFee(amount, isPremium);
            double newBalance = getBalance() - amount - fee;
            addTransaction(new Transaction(accountNumber, amount, fee, true, dateTime));
            setBalance(newBalance);
            System.out.println("Giao dich thanh cong");
            log(dateTime, accountNumber, amount, newBalance, fee);
            return true;
        }
        //nếu khoản rút không được chấp nhận
        //tạo một transaction mới với thông tin giao dịch không thành công
        addTransaction(new Transaction(accountNumber, amount, 0, false, dateTime));
        System.out.println("Giao dich khong thanh cong");
        return false;
    }

    @Override
    public boolean isAccepted(double amount, boolean isPremium) {
        //khoản rút phải >= 50 000
        //là bội số của 10 000
        // < 100 000 000
        //tài khoản phải còn >=50 000 nếu rút thành công
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
        double newBalance = getBalance() - amount - getFee(amount, isPremium);
        if (newBalance < ACCOUNT_MIN_BALANCE) {
            System.out.println("So du hien tai khong du");
            return false;
        }
        return true;
    }


    @Override
    public void log(String dateTime, String accountNumber, double amount, double newBalance, double fee) {
        System.out.println("+------+-----------------------+------+");
        System.out.println("      BIEN LAI GIAO DICH SAVINGS       ");
        System.out.printf("NGAY GIAO DICH: %22s%n", dateTime);
        System.out.printf("ATM ID: %30s%n", "DIGITAL-BANK-ATM 2023");
        System.out.printf("SO TAI KHOAN SAVINGS: %16s%n", accountNumber);
        System.out.printf("SO TIEN: %27s%s%n", String.format("%,.0f", ((-1) * amount)), " đ");
        System.out.printf("SO DU: %29s%s%n", String.format("%,.0f", newBalance), " đ");
        System.out.printf("PHI + VAT: %25s%s%n", String.format("%,.0f", fee), " đ");
        System.out.println("+------+-----------------------+------+");
    }

    @Override
    public String toString() {
        return String.format("%s %-20s %,.0f%s", getAccountNumber(), "| SAVINGS | ", getBalance(), " đ");
    }
}
