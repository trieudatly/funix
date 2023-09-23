import models.Bank;
import models.Customer;
import models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Asm02 {
    //tạo scanner dùng chung
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //tạo 2 hằng lưu tác giả và phiên bản
        final String AUTHOR = "fx22205";
        final String VERSION = "2.0.0";
        //tạo đối tượng bank kiểu Bank
        Bank bank = new Bank();
        //khai báo 1 danh sách kiểu Customer
        List<Customer> customerList = new ArrayList<>();
        //biến choice dùng để lưu lựa chọn của user
        int choice;
        String cccd;
        //gọi phương thức mainMenu với 2 tham số author và version
        mainMenu(AUTHOR, VERSION);
        while (true) {
            System.out.print("Chuc nang: ");
            //nhập lựa chọn của user
            //dùng try catch để bắt lỗi, nếu người dùng nhập không phải số
            // => in ra thông báo lỗi
            try {
                choice = Integer.parseInt(sc.next());
            } catch (NumberFormatException nfe) {
                System.out.println("Nhap 1 2 3 4 5 0 de chon chuc nang");
                //bỏ qua code bên dưới, chạy lại vòng lặp
                continue;
            }
            switch (choice) {
                case 1:
                    //thêm một đối tượng Customer mới vào đối tượng bank
                    bank.addCustomer(new Customer());
                    //làm mới customerList
                    customerList = bank.getCustomers();
                    break;
                case 2:
                    if (customerList.isEmpty()) {
                        System.out.println("Chua co khach hang nao.");
                        break;
                    }
                    while (true) {
                        cccd = User.cccdInput();
                        if (bank.isCustomerExisted(cccd)) {
                            for (Customer customer : customerList
                            ) {
                                if (cccd.equals(customer.getCustomerId())) {
                                    customer.addAccount();
                                    break;
                                }
                            }
                            break;
                        } else {
                            System.out.println("Khach hang khong ton tai");
                        }
                    }
                    break;
                case 3:
                    if (customerList.isEmpty()) {
                        System.out.println("Chua co khach hang nao.");
                        break;
                    }
                    for (Customer customer : customerList
                    ) {
                        customer.displayinformation();
                    }
                    break;
                case 4:
                    if (customerList.isEmpty()) {
                        System.out.println("Chua co khach hang nao.");
                        break;
                    }
                    while (true) {
                        cccd = User.cccdInput();
                        if (bank.isCustomerExisted(cccd)) {
                            for (Customer customer : customerList
                            ) {
                                if (cccd.equals(customer.getCustomerId())) {
                                    customer.displayinformation();
                                    break;
                                }
                            }
                            break;
                        } else {
                            System.out.println("Khach hang khong ton tai");
                        }
                    }

                    break;
                case 5:
                    if (customerList.isEmpty()) {
                        System.out.println("Chua co khach hang nao.");
                        break;
                    }
                    int customerCount = 0;
                    System.out.println("Nhap ten khach hang: ");
                    String name = sc.next();
                    for (Customer customer : customerList
                    ) {
                        if (customer.getName().contains(name)) {
                            customerCount++;
                            customer.displayinformation();
                        }
                    }
                    if (customerCount == 0) {
                        System.out.println("Khach hang khong ton tai");
                    }
                    break;
                case 0:
                    //thông báo tạm biệt
                    System.out.println("Bye Bye");
                    //thoát chương trình
                    System.exit(0);
                    break;
                default:
                    //nếu người dùng nhập một số khác 1 2 3 4 5 0
                    // => in ra thông báo lỗi
                    System.out.println("Nhap 1 2 3 4 5 0 de chon chuc nang");
                    break;
            }
        }
    }

    //Menu Chính
    private static void mainMenu(String author, String version) {
        System.out.println("+----------+-------------------+----------+");
        System.out.println("| NGAN HANG SO | " + author + "@v" + version + "           |");
        System.out.println("+----------+-------------------+----------+");
        System.out.println(" 1.Them khach hang");
        System.out.println(" 2.Them tai khoan cho khach hang");
        System.out.println(" 3.Hien thi danh sach khach hang");
        System.out.println(" 4.Tim theo ten khach hang");
        System.out.println(" 5.Tim theo CCCD");
        System.out.println(" 0.Thoat");
        System.out.println("+----------+-------------------+----------+");
    }
}