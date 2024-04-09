import model.Account;
import model.DigitalBank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Asm4 {
    private static final int EXIT_COMMAND_CODE = 0;
    private static final int EXIT_ERROR_CODE = -1;
    private static final Scanner sc = new Scanner(System.in);
    private static final DigitalBank activeBank = new DigitalBank();

    public static void main(String[] args) {
        //tạo 2 hằng lưu tác giả và phiên bản
        final String AUTHOR = "fx22205";
        final String VERSION = "4.0.0";
        List<Account> accounts = new ArrayList<>();
        //biến choice dùng để lưu lựa chọn của user
        int choice;
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
                    //Xem danh sách khách hàng
                    showCustomers();
                    break;
                case 2:
                    //Nhập danh sách khách hàng
                    addCustomers();
                    break;
                case 3:
                    //Thêm tài khoản ATM
                    addAccount();
                    break;
                case 4:
                    //Chuyển tiền
                    break;
                case 5:
                    //Rút tiền
                    withdraw();
                    break;
                case 6:
                    //Tra cứu lịch sử giao dịch
                    break;
                case 0:
                    //Thoát
                    //thông báo tạm biệt
                    System.out.println("Bye Bye");
                    //thoát chương trình
                    System.exit(0);
                    break;
                default:
                    //nếu người dùng nhập một số khác 1 2 3 4 5 6 0
                    // => in ra thông báo
                    System.out.println("Nhap 1 2 3 4 5 6 0 de chon chuc nang");
                    break;
            }
        }
    }

    private static void withdraw() {
        activeBank.withdraw();
    }

    private static void addAccount() {
        activeBank.addSavingAccount();
    }

    private static void addCustomers() {
        System.out.println("Nhap duong dan den tep:");
        sc.nextLine();
        activeBank.addCustomers(sc.nextLine());
    }

    private static void showCustomers() {
        activeBank.showCustomers();
    }


    private static void mainMenu(String author, String version) {
        System.out.println("+----------+-------------------+----------+");
        System.out.println("| NGAN HANG DIEN TU | " + author + "@v" + version + "           |");
        System.out.println("+----------+-------------------+----------+");
        System.out.println(" 1.Xem danh sach khach hang");
        System.out.println(" 2.Nhap danh sach khach hang");
        System.out.println(" 3.Them tai khoan ATM");
        System.out.println(" 4.Chuyen tien");
        System.out.println(" 5.Rut tien");
        System.out.println(" 6.Tra cuu lich su giao dich");
        System.out.println(" 0.Thoat");
        System.out.println("+----------+-------------------+----------+");
    }

    //header cho log
    private static void displayTransactionHeader() {
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        System.out.println("| Tai Khoan   | Thoi Gian           | Trang Thai       | Ma Giao Dich                         | So Tien");
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
    }
}