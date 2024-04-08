package service;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    static Scanner sc = new Scanner(System.in);
    //tạo 1 String với pattern dùng dể so khớp
    // ^ và $ để khai báo bắt đầu và kết thúc 1 pattern
    // \\d{12} tức là 12 số bất kì từ 0-9 vì số CCCD có 12 chữ số
    static final String CCCD_PATTERN = "^\\d{12}$";
    // \\d{6} tức là 6 số bất kì từ 0-9 vì số accountNumber có 6 chữ số
    static final String ACCOUNT_PATTERN = "^\\d{6}$";

    // ? có hoặc không số bất kì từ 0-9, hoặc dấu .
    static final String AMOUNT_PATTERN = "^([0-9]*[.])?[0-9]+$";

    public static boolean validateCustomerId(String customerId) {
        return Pattern.matches(CCCD_PATTERN, customerId);
    }

    public static boolean validateAccountNumber(String accountNumber) {
        return Pattern.matches(ACCOUNT_PATTERN, accountNumber);
    }

    //Xử lý CCCD
    public static String customerIdInput() {
        System.out.print("Nhap ID khach hang: ");
        return getInputWithPattern(CCCD_PATTERN);
    }

    public static String accountInput() {
        System.out.print("Nhap ma tai khoan: ");
        return getInputWithPattern(ACCOUNT_PATTERN);
    }

    public static double amountInput() {
        while (true) {
            System.out.print("Nhap so tien: ");
            double amount = Double.parseDouble(getInputWithPattern(AMOUNT_PATTERN));
            // số dư của tài khoản, không được nhỏ hơn 50_000 VNĐ
            if (amount >= 50000 && amount % 10000 == 0) {
                return amount;
            }
            System.out.println("so tien phai lon hon hoac bang 50,000 va la boi so cua 10 000");
        }
    }

    //nhập thông tin từ bàn phím
    //so khớp theo PATTERN
    public static String getInputWithPattern(String pattern) {
        while (true) {
            String input = sc.nextLine().trim().toLowerCase();
            if (input.compareTo("no") == 0) {
                System.out.println("Bye Bye");
                System.exit(0);
            }
            if (!Pattern.matches(pattern, input)) {
                System.out.print("Khong hop le. Vui long nhap lai:");
            } else {
                return input;
            }
        }
    }
}
