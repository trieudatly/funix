package models;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Account {
    static Scanner sc = new Scanner(System.in);
    private String accountNumber;
    private double balance;

    public Account() {
        //sc.nextLine();
        accountNumber = accountInput();
        balance = balanceInput();
    }

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        balance = balanceInput();
    }

    public static double balanceInput() {
        String accBalance = "";
        while (true) {
            System.out.print("Nhap so du tai khoan: ");
            //tạo 1 String với pattern dùng dể so khớp
            // ^ và $ để khai báo bắt đầu và kết thúc 1 pattern
            // \\d tức là số bất kì từ 0-9
            // {12} lặp lại 12 lần vì số CCCD có 12 chữ số
            String cccdPattern = "^\\d+$";
            //nhập CCCD, cắt bỏ khoảng trắng ở đầu đuôi,tất cả viết thường
            accBalance = sc.nextLine().trim().toLowerCase();
            if (accBalance.compareTo("no") == 0) {
                //nếu cccd bằng "no" => thoát
                System.out.println("Bye Bye");
                System.exit(0);
            } else if (!Pattern.matches(cccdPattern, accBalance)) {
                //nếu cccd không khớp pattern => in thông báo lỗi
                System.out.println("So ma tai khoan khong hop le.\nVui long nhap lai hoac 'No' de thoat");
            } else {
                //nếu cccd khớp pattern tức là cccd hợp lệ
                return Double.parseDouble(accBalance);
            }
        }
    }

    public static String accountInput() {
        String accNum;
        while (true) {
            System.out.print("Nhap so ma tai khoan: ");
            //tạo 1 String với pattern dùng dể so khớp
            // ^ và $ để khai báo bắt đầu và kết thúc 1 pattern
            // \\d tức là số bất kì từ 0-9
            // {12} lặp lại 12 lần vì số CCCD có 12 chữ số
            String cccdPattern = "^\\d{6}$";
            //nhập CCCD, cắt bỏ khoảng trắng ở đầu đuôi,tất cả viết thường
            accNum = sc.nextLine().trim().toLowerCase();
            if (accNum.compareTo("no") == 0) {
                //nếu cccd bằng "no" => thoát
                System.out.println("Bye Bye");
                System.exit(0);
            } else if (!Pattern.matches(cccdPattern, accNum)) {
                //nếu cccd không khớp pattern => in thông báo lỗi
                System.out.println("So ma tai khoan khong hop le.\nVui long nhap lai hoac 'No' de thoat");
            } else {
                //nếu cccd khớp pattern tức là cccd hợp lệ
                return accNum;
            }
        }
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

    public boolean isPremium() {
        if (balance >= 10000000) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return accountNumber + "|" + String.format("%,.0f", balance) + "đ";
    }
}
