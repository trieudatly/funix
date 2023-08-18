package models;

import java.util.Scanner;
import java.util.regex.Pattern;

public class User {
    //tạo scanner dùng chung
    static Scanner sc = new Scanner(System.in);
    //tạo biến cccd để lưu căn cước nhập vào

    private String name;
    private String customerId;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName() {
        sc.nextLine();
        System.out.print("Nhap ten: ");
        this.name = sc.nextLine();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    //Xử lý CCCD
    private void setCustomerId() {
        String cccd = "";
        sc.nextLine();
        while (true) {
            System.out.print("Nhap so CCCD: ");
            //tạo 1 String với pattern dùng dể so khớp
            // ^ và $ để khai báo bắt đầu và kết thúc 1 pattern
            // \\d tức là số bất kì từ 0-9
            // {12} lặp lại 12 lần vì số CCCD có 12 chữ số
            String cccdPattern = "^\\d{12}$";
            //nhập CCCD, cắt bỏ khoảng trắng ở đầu đuôi,tất cả viết thường
            cccd = sc.nextLine().trim().toLowerCase();
            if (cccd.compareTo("no") == 0) {
                //nếu cccd bằng "no" => thoát
                System.out.println("Bye Bye");
                System.exit(0);
            } else if (!Pattern.matches(cccdPattern, cccd)) {
                //nếu cccd không khớp pattern => in thông báo lỗi
                System.out.println("So CCCD khong hop le.\nVui long nhap lai hoac 'No' de thoat");
            } else {
                //nếu cccd khớp pattern tức là cccd hợp lệ
                customerId = cccd;
                break;
            }
        }
    }
}
