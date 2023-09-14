import models.Bank;
import models.Customer;
import models.User;

import java.util.List;
import java.util.Scanner;

public class Asm02 {
    //tạo scanner dùng chung
    static Scanner sc = new Scanner(System.in);
    private static final Bank bank = new Bank();

    public static void main(String[] args) {
        //tạo 2 hằng lưu tác giả và phiên bản
        final String AUTHOR = "fx22205";
        final String VERSION = "2.0.0";
        Bank bk = new Bank();
        //biến choice dùng để lưu lựa chọn của user
        int choice;
        //gọi phương thức menu với 2 tham số author và version
        mainMenu(AUTHOR, VERSION);
        while (true) {
            System.out.print("Chuc nang: ");
            //nhập lựa chọn của user
            //dùng try catch để bắt lỗi, nếu người dùng nhập không phải số => in ra thông báo lỗi
            try {
                choice = Integer.parseInt(sc.next());
            } catch (Exception e) {
                System.out.println("Nhap 1 hoac 0");
                continue;
            }
            switch (choice) {
                case 1:
                    //                    Account acc = new Account("123456", 10000000);
                    //                    Account acc1 = new Account("123457", 10000000);
                    //                    Customer customer = new Customer("Dat", "03745689111");
                    //                    customer.addAcount(acc);
                    //                    customer.addAcount(acc1);
                    //                    Bank bk = new Bank();
                    //                    bk.addCustomer(customer);
                    //                    List<Customer> list = bk.getCustomers();
                    //                    for (Customer cus : list
                    //                    ) {
                    //                        cus.displayinformation();
                    //                    }

                    bk.addCustomer(new Customer());

                    break;
                case 2:
                    int customerCheck = 0;
                    while (customerCheck == 0) {
                        String cccd = User.getCCCD();
                        List<Customer> listCus = bk.getCustomers();
                        for (Customer cus : listCus
                        ) {
                            if (cccd.equals(cus.getCustomerId())) {
                                customerCheck++;
                                cus.addAccount();
                                break;
                            }
                        }
                        if (customerCheck == 0) {
                            System.out.println("Khach hang khong ton tai");
                        }
                    }

                    break;
                case 3:
                    List<Customer> list = bk.getCustomers();
                    for (Customer cus : list
                    ) {
                        cus.displayinformation();
                    }
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 0:
                    //thông báo tạm biệt
                    System.out.println("Bye Bye");
                    //thoát chương trình
                    System.exit(0);
                    break;
                default:
                    //nếu người dùng nhập một số khác 1 hoặc 0 => in ra thông báo lỗi
                    System.out.println("Nhap 1 hoac 0");
                    break;
            }
        }
    }

    //Menu Chính
    private static void mainMenu(String author, String version) {
        System.out.println("+----------+-------------------+----------+");
        System.out.println("| NGAN HANG SO | " + author + "@v" + version + "           |");
        System.out.println("+----------+-------------------+----------+");
        System.out.println("| 1.Them khach hang                       |");
        System.out.println("| 2.Them tai khoan cho khach hang         |");
        System.out.println("| 3.Hien thi danh sach khach hang         |");
        System.out.println("| 4.Tim theo ten khach hang               |");
        System.out.println("| 5.Tim theo CCCD                         |");
        System.out.println("| 0.Thoat                                 |");
        System.out.println("+----------+-------------------+----------+");
    }
}