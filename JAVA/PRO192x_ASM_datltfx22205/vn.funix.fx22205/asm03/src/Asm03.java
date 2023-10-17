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
        //Customer customer1 = new Customer("001215000002", "dat");
        //System.out.println(customer1.getCustomerId());
        activeBank.addCustomer(customer);
        //activeBank.addCustomer(customer1);
        //tạo đối tượng bank kiểu Bank
        //Bank bank = new Bank();
        //khai báo 1 danh sách kiểu Customer
        //List<Customer> customerList = new ArrayList<>();
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
//                    //Chức năng thêm khách hàng.
//                    //thêm một đối tượng Customer mới vào đối tượng bank
//                    bank.addCustomer(new Customer());
//                    //làm mới customerList
//                    customerList = bank.getCustomers();


//                    Customer customer = activeBank.getCustomerById(CUSTOMER_ID);
//                    if (customer != null) {
//                        customer.displayInformation();
//                    }
                    showCustomer();
                    break;

                case 2:
//                    //Chức năng thêm tài khoản cho khách hàng.
//                    //nếu bank chưa có khách hàng nào thì thông báo
//                    if (customerList.isEmpty()) {
//                        System.out.println("Chua co khach hang nao.");
//                        break;
//                    }
//                    while (true) {
//                        //nhập CCCD khách hàng
//                        cccd = User.cccdInput();
//                        //nếu khách hàng tồn tại => thêm tài khoản mới vào khách hàng cụ thể
//                        //thoát vòng lặp
//                        if (bank.isCustomerExisted(cccd)) {
//                            for (Customer customer : customerList
//                            ) {
//                                if (cccd.equals(customer.getCustomerId())) {
//                                    customer.addAccount();
//                                    break;
//                                }
//                            }
//                            break;
//                        } else {
//                            //nếu khách hàng không tồn tại=>thông báo lỗi
//                            System.out.println("Khach hang khong ton tai");
//                        }
//                    }
                    addSavingsAccount();
                    break;
                case 3:
//                    //Hiển thị danh sách khách hàng.
//                    if (customerList.isEmpty()) {
//                        System.out.println("Chua co khach hang nao.");
//                        break;
//                    }
//                    for (Customer customer : customerList
//                    ) {
//                        customer.displayInformation();
//                    }
                    addLoanAccount();
                    break;
                case 4:
//                    //Tìm theo CCCD.
//                    if (customerList.isEmpty()) {
//                        System.out.println("Chua co khach hang nao.");
//                        break;
//                    }
//                    while (true) {
//                        //nhập CCCD khách hàng
//                        cccd = User.cccdInput();
//                        //nếu khách hàng tồn tại => hiển thị khách hàng.
//                        //thoát vòng lặp
//                        if (bank.isCustomerExisted(cccd)) {
//                            for (Customer customer : customerList
//                            ) {
//                                if (cccd.equals(customer.getCustomerId())) {
//                                    customer.displayInformation();
//                                    break;
//                                }
//                            }
//                            break;
//                        } else {
//                            //nếu khách hàng không tồn tại=>thông báo
//                            System.out.println("Khach hang khong ton tai");
//                        }
//                    }
                    withdraw();
                    break;
                case 5:
//                    //Tìm theo tên khách hàng.
//                    if (customerList.isEmpty()) {
//                        System.out.println("Chua co khach hang nao.");
//                        break;
//                    }
//                    //tạo biến để đếm số lượng khách hàng tìm thấy
//                    int customerCount = 0;
//                    //nhập tên khách hàng
//                    System.out.println("Nhap ten khach hang: ");
//                    String name = sc.next();
//                    for (Customer customer : customerList
//                    ) {
//                        if (customer.getName().contains(name)) {
//                            //mỗi khách hàng tìm được, biến customerCount sẽ +1 giá trị
//                            customerCount++;
//                            //hiển thị khách hàng.
//                            customer.displayInformation();
//                        }
//                    }
//                    if (customerCount == 0) {
//                        //nếu customerCount=0 thì không tồn tại  khách hàng nào=>thông báo
//                        System.out.println("Khach hang khong ton tai");
//                    }
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

    private static void showCustomer() {

        Customer customer = activeBank.getCustomerById(CUSTOMER_ID);
        if (customer != null) {
            customer.displayInformation();
        }

    }

    private static void addSavingsAccount() {
        System.out.println("Nhap STK gom 6 chu so: ");
        String STK = scanner.nextLine();
        while (STK.length() != 6) {
            System.out.println("STK co 6 chu so, vui long nhap lai: ");
            STK = scanner.nextLine();
        }
        System.out.println("Nhap so du: ");
        double soDu = input.nextDouble();
        while (soDu < 50000) {
            System.out.println("So du phai lon hon hoac bang 50k");
            System.out.println("Nhap so du: ");
            soDu = input.nextDouble();
        }
        Account savingsAccount = new SavingsAccount(STK, soDu);
        activeBank.addAccount(CUSTOMER_ID, savingsAccount);
    }

    private static void addLoanAccount() {
        System.out.println("Nhap STK gom 6 chu so: ");
        String STK = scanner.nextLine();
        while (STK.length() != 6) {
            System.out.println("STK co 6 chu so, vui long nhap lai: ");
            STK = scanner.nextLine();
        }
        Account loanAccount = new LoanAccount(STK);
        activeBank.addAccount(CUSTOMER_ID, loanAccount);
    }

    private static void withdraw() {
        System.out.println("Nhap ma so tai khoan can rut: ");
        String accountId = scanner.nextLine();
        System.out.println("Nhap so tien can rut: ");
        double amount = input.nextDouble();
        activeBank.withdraw(CUSTOMER_ID, accountId, amount);
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