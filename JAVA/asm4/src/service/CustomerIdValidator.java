package service;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CustomerIdValidator {
    static Scanner sc = new Scanner(System.in);
    //tạo 1 String với pattern dùng dể so khớp
    // ^ và $ để khai báo bắt đầu và kết thúc 1 pattern
    // \\d{12} tức là 12 số bất kì từ 0-9 vì số CCCD có 12 chữ số
    static final String CCCD_PATTERN = "^\\d{12}$";

    public static boolean validateCustomerId(String customerId) {
        return Pattern.matches(CCCD_PATTERN, customerId);
    }

    //Xử lý CCCD
    public static String cccdInput() {
        System.out.print("Nhap CCCD khach hang: ");
        return getInputWithPattern(CCCD_PATTERN);
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
