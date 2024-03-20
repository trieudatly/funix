import models.*;
import utility.FileService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Asm4 {
    private static final int EXIT_COMMAND_CODE = 0;
    private static final int EXIT_ERROR_CODE = -1;
    private static final Scanner sc = new Scanner(System.in);
    private static final DigitalBank activeBank = new DigitalBank();
    private static final String CUSTOMER_ID = "001215000001";
    private static final String CUSTOMER_NAME = "FUNIX";
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
    //hiện thông tin khách hàng
    private static void showCustomerById() {
       DigitalCustomer customer = activeBank.getCustomerById(CUSTOMER_ID);
        if (customer != null) {
            customer.displayInformation();
        }
    }
    private static void showAllCustomer() {
        List<Customer> customers = activeBank.getCustomers();
        if(!customers.isEmpty()){
            for (Customer customer : customers
            ) {
                customer.displayInformation();
            }
        }
    }
    //Thêm tài khoản Savings cho khách hàng.
    private static void addSavingsAccount() {
        SavingAccount savingsAccount = new SavingAccount(Account.accountNumberInput(),Account.amountInput());
        activeBank.addAccount(CUSTOMER_ID, savingsAccount);
    }

    //Thêm tài khoản LOAN cho khách hàng
    private static void addLoanAccount() {
        LoanAccount loanAccount = new LoanAccount(Account.accountNumberInput());
        activeBank.addAccount(CUSTOMER_ID, loanAccount);
    }

    private static void withdraw() {
        //Rút tiền
        activeBank.withdraw(CUSTOMER_ID);
    }

    //Hiện lịch sử giao dịch tất cả tài khoản SAVING và LOAN của khách hàng
    private static void showLog() {
        DigitalCustomer customer = activeBank.getCustomerById(CUSTOMER_ID);
        customer.displayInformation();
        displayTransactionHeader();
        List<Account> accountList = customer.getAccounts();
        for (Account account : accountList
        ) {
            account.displayAllTransactions();
        }
    }
    //header cho log
    private static void displayTransactionHeader() {
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
        System.out.println("| Tai Khoan   | Thoi Gian           | Trang Thai       | Ma Giao Dich                         | So Tien");
        System.out.println("+-----------------------------------------------------------------------------------------------------------------+");
    }
    private static void SaveAndReadFromFile(){
        List<Customer> customers = activeBank.getCustomers();
//        if(!customers.isEmpty()){
//            for (Customer customer : customers
//            ) {
//                customer.displayInformation();
//            }
//        }
        FileService.writeToDataFile( customers,"store/customer.dat");
        // đọc dữ liệu từ file
        List<Customer> readCustomers = FileService.readFromDataFile("store/customer.dat");
        System.out.println("List customer in file: ");
        for (Customer customer : readCustomers
        ) {
            customer.displayInformation();
        }
    }
    public static void main(String[] args) {
        //tạo 2 hằng lưu tác giả và phiên bản
        final String AUTHOR = "fx22205";
        final String VERSION = "3.0.0";
        List<Account> accounts = new ArrayList<>();
        DigitalCustomer customer = new DigitalCustomer("001215000001", CUSTOMER_NAME);
        DigitalCustomer customer1 = new DigitalCustomer("001215000002", CUSTOMER_NAME);
        DigitalCustomer customer2 = new DigitalCustomer("001215000003", CUSTOMER_NAME);
        DigitalCustomer customer3 = new DigitalCustomer("001215000004", CUSTOMER_NAME);
        activeBank.addCustomer(customer);
        activeBank.addCustomer(customer1);
        activeBank.addCustomer(customer2);
        activeBank.addCustomer(customer3);
        //DigitalCustomer customer = new DigitalCustomer(CUSTOMER_ID, CUSTOMER_NAME);
        //activeBank.addCustomer(customer);
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
                    //showCustomerById();
                    showAllCustomer();
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
                case 6:
                    //Hiện lịch sử giao dịch tất cả tài khoản SAVING và LOAN của khách hàng
                    SaveAndReadFromFile();
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
}