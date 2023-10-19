import models.*;

import java.util.List;
import java.util.Scanner;

public class Asm03 {
    private static final int EXIT_COMMAND_CODE = 0;
    private static final int EXIT_ERROR_CODE = -1;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Scanner sc = new Scanner(System.in);
    private static final Scanner input = new Scanner(System.in);
    private static final DigitalBank activeBank = new DigitalBank();
    private static final String CUSTOMER_ID = "001215000001";
    private static final String CUSTOMER_NAME = "FUNIX";


    public static void main(String[] args) {
        //tạo 2 hằng lưu tác giả và phiên bản
        final String AUTHOR = "fx22205";
        final String VERSION = "3.0.0";
        Customer customer = new DigitalCustomer(CUSTOMER_ID, CUSTOMER_NAME);
        activeBank.addCustomer(customer);
        //biến choice dùng để lưu lựa chọn của user
        int choice;
        //String cccd;
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
                    //hiện thông tin khách hàng
                    showCustomer();
                    break;
                case 2:
                    //Thêm tài khoản Savings cho khách hàng.
                    addSavingsAccount();
                    break;
                case 3:
                    //Thêm tài khoản LOAN cho khách hàng
                    addLoanAccount();
                    break;
                case 4:
                    //Rút tiền
                    withdraw();
                    break;
                case 5:
                    //Hiện lịch sử giao dịch tất cả tài khoản SAVING và LOAN của khách hàng
                    showLog();
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
        System.out.println(" 1.Thong tin khach hang");
        System.out.println(" 2.Them tai khoan ATM");
        System.out.println(" 3.Them tai khoan tin dung");
        System.out.println(" 4.Rut tien");
        System.out.println(" 5.Lich su giao dich");
        System.out.println(" 0.Thoat");
        System.out.println("+----------+-------------------+----------+");
    }

    //hiện thông tin khách hàng
    private static void showCustomer() {
        Customer customer = activeBank.getCustomerById(CUSTOMER_ID);
        if (customer != null) {
            customer.displayInformation();
        }
    }

    private static void addSavingsAccount() {
        SavingsAccount savingsAccount = new SavingsAccount();
        activeBank.addAccount(CUSTOMER_ID, savingsAccount);
    }

    private static void addLoanAccount() {
        LoanAccount loanAccount = new LoanAccount();
        activeBank.addAccount(CUSTOMER_ID, loanAccount);
    }

    private static void withdraw() {
        //Rút tiền
        activeBank.withdraw();
    }

    private static void showLog() {
        Customer customer = activeBank.getCustomerById(CUSTOMER_ID);
//        System.out.println("Tra cuu lich su giao dich: ");
        customer.displayInformation();
        Account.displayTransactionHeader();
        List<Account> accountList = customer.getAccounts();
        for (Account account : accountList
        ) {
            account.displayAllTransactions();
        }
//        System.out.println("Nhap STK muon sao ke: ");
//        String STK = scanner.nextLine();
//        while (STK.length() != 6) {
//            System.out.println("STK co 6 chu so, vui long nhap lai: ");
//            STK = scanner.nextLine();
//        }
//        Account acc = customer.getAccountByAccounNumber(STK);
//        if (acc != null) {
//            acc.displayAllTransactions();
//        } else {
//            System.out.println("STK khong ton tai!!");
//        }
    }
}