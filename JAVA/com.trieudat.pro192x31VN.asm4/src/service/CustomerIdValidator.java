package service;

import java.util.regex.Pattern;

public class CustomerIdValidator {
    //tạo 1 String với pattern dùng dể so khớp
    // ^ và $ để khai báo bắt đầu và kết thúc 1 pattern
    // \\d{12} tức là 12 số bất kì từ 0-9 vì số CCCD có 12 chữ số
    static final String CCCD_PATTERN = "^\\d{12}$";

    public static boolean validateCustomerId(String customerId) {
        return Pattern.matches(CCCD_PATTERN, customerId);
    }
}
