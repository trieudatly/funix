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
                    //Chức năng thêm khách hàng.
                    //thêm một đối tượng Customer mới vào đối tượng bank
                    bank.addCustomer(new Customer());
                    //làm mới customerList
                    customerList = bank.getCustomers();
                    break;
                case 2:
                    //Chức năng thêm tài khoản cho khách hàng.
                    //nếu bank chưa có khách hàng nào thì thông báo
                    if (customerList.isEmpty()) {
                        System.out.println("Chua co khach hang nao.");
                        break;
                    }
                    while (true) {
                        //nhập CCCD khách hàng
                        cccd = User.cccdInput();
                        //nếu khách hàng tồn tại => thêm tài khoản mới vào khách hàng cụ thể
                        //thoát vòng lặp
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
                            //nếu khách hàng không tồn tại=>thông báo lỗi
                            System.out.println("Khach hang khong ton tai");
                        }
                    }
                    break;
                case 3:
                    //Hiển thị danh sách khách hàng.
                    if (customerList.isEmpty()) {
                        System.out.println("Chua co khach hang nao.");
                        break;
                    }
                    for (Customer customer : customerList
                    ) {
                        customer.displayInformation();
                    }
                    break;
                case 4:
                    //Tìm theo CCCD.
                    if (customerList.isEmpty()) {
                        System.out.println("Chua co khach hang nao.");
                        break;
                    }
                    while (true) {
                        //nhập CCCD khách hàng
                        cccd = User.cccdInput();
                        //nếu khách hàng tồn tại => hiển thị khách hàng.
                        //thoát vòng lặp
                        if (bank.isCustomerExisted(cccd)) {
                            for (Customer customer : customerList
                            ) {
                                if (cccd.equals(customer.getCustomerId())) {
                                    customer.displayInformation();
                                    break;
                                }
                            }
                            break;
                        } else {
                            //nếu khách hàng không tồn tại=>thông báo
                            System.out.println("Khach hang khong ton tai");
                        }
                    }

                    break;
                case 5:
                    //Tìm theo tên khách hàng.
                    if (customerList.isEmpty()) {
                        System.out.println("Chua co khach hang nao.");
                        break;
                    }
                    //tạo biến để đếm số lượng khách hàng tìm thấy
                    int customerCount = 0;
                    //nhập tên khách hàng
                    System.out.println("Nhap ten khach hang: ");
                    String name = sc.next();
                    for (Customer customer : customerList
                    ) {
                        if (customer.getName().contains(name)) {
                            //mỗi khách hàng tìm được, biến customerCount sẽ +1 giá trị
                            customerCount++;
                            //hiển thị khách hàng.
                            customer.displayInformation();
                        }
                    }
                    if (customerCount == 0) {
                        //nếu customerCount=0 thì không tồn tại  khách hàng nào=>thông báo
                        System.out.println("Khach hang khong ton tai");
                    }
                    break;
                case 0:
                    //Thoát
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