package models;

import java.util.Scanner;

public class User {
    //tạo scanner dùng chung
    static Scanner sc = new Scanner(System.in);

    private String name;
    private String customerId;

    public User() {
        setName();
        setCustomerId();
    }

    public User(String userId, String name) {
        this.customerId = userId;
        this.name = name;
    }

    //Xử lý CCCD
    public static String cccdInput() {
        //tạo 1 String với pattern dùng dể so khớp
        // ^ và $ để khai báo bắt đầu và kết thúc 1 pattern
        // \\d{12} tức là 12 số bất kì từ 0-9 vì số CCCD có 12 chữ số
        final String CCCD_PATTERN = "^\\d{12}$";
        System.out.print("Nhap CCCD khach hang: ");
        return Utility.getInputWithPattern(CCCD_PATTERN);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName() {
        System.out.print("Nhap ten: ");
        this.name = sc.nextLine();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    private void setCustomerId() {
        customerId = cccdInput();
    }
}
