package models;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Account {
    static Scanner sc = new Scanner(System.in);
    private String accountNumber;
    private double balance;

    public Account() {
        accountNumber = accountNumberInput();
        balance = balanceInput();
    }

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        balance = balanceInput();
    }

    public static double balanceInput() {
        //tạo 1 String với pattern dùng dể so khớp
        // ^ và $ để khai báo bắt đầu và kết thúc 1 pattern
        // \\d tức là số bất kì từ 0-9
        //final String BALANCE_PATTERN = "^\\d+$";
        final String BALANCE_PATTERN = "^([0-9]*[.])?[0-9]+$";
        while (true) {
            System.out.print("Nhap so du tai khoan: ");
            double balance = Double.parseDouble(getInputWithPattern(BALANCE_PATTERN));
            //System.out.println("balance is: " + balance);
            if (balance >= 50000) {
                return balance;
            }
            System.out.println("so du phai lon hon hoac bang 50,000VND");
        }

    }

    public static String accountNumberInput() {
        //tạo 1 String với pattern dùng dể so khớp
        // ^ và $ để khai báo bắt đầu và kết thúc 1 pattern
        // \\{6} tức là 6 số bất kì từ 0-9
        final String ACCOUNT_PATTERN = "^\\d{6}$";
        System.out.print("Nhap so ma tai khoan(gom 6 chu so): ");
        return getInputWithPattern(ACCOUNT_PATTERN);
    }

    private static String getInputWithPattern(String pattern) {
        while (true) {
            String input = sc.nextLine().trim().toLowerCase();
            if (input.compareTo("no") == 0) {
                System.out.println("Bye Bye");
                System.exit(0);
            }
            if (!Pattern.matches(pattern, input)) {
                System.out.print("khong hop le. Vui long nhap lai:");
            } else {
                return input;
            }
        }
    }

    public boolean isPremium() {
        if (balance >= 10000000) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %-20s %,.3f%s", accountNumber, "|", balance, "đ");
    }

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
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


}
