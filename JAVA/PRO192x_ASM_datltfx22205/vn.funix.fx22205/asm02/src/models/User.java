package models;

import java.util.Scanner;
import java.util.regex.Pattern;

public class User {
    //tạo scanner dùng chung
    static Scanner sc = new Scanner(System.in);

    private String name;
    private String customerId;

    public User() {
        setName();
        setCustomerId();
    }

    public User(String name, String customerId) {
        setName(name);
        setCustomerId(customerId);
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

    //Xử lý CCCD
    public static String cccdInput() {
        String cccd = "";
        while (true) {
            System.out.print("Nhap CCCD khach hang: ");
            //tạo 1 String với pattern dùng dể so khớp
            // ^ và $ để khai báo bắt đầu và kết thúc 1 pattern
            // \\d{12} tức là 12 số bất kì từ 0-9 vì số CCCD có 12 chữ số
            String cccdPattern = "^\\d{12}$";
            //nhập CCCD, cắt bỏ khoảng trắng ở đầu đuôi,tất cả viết thường
            cccd = sc.nextLine().trim().toLowerCase();
            if (cccd.compareTo("no") == 0) {
                //nếu cccd bằng "no" => thoát
                System.out.println("Bye Bye");
                System.exit(0);
            }
            if (Pattern.matches(cccdPattern, cccd)) {
                //nếu cccd khớp pattern tức là cccd hợp lệ
                return cccd;
            } else {
                //nếu cccd không khớp pattern => in thông báo lỗi
                System.out.println("So CCCD khong hop le.\nVui long nhap lai hoac 'No' de thoat");
            }
        }
    }
}
