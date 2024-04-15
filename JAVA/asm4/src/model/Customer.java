package model;

import dao.AccountDao;
import exception.CustomerIdNotValidException;
import service.Validator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Customer implements Serializable {
    //Implements Serializable và thuộc tính
    // static final long serialVersionUID để hỗ trợ đọc/ghi object.
    private static final long serialVersionUID = 1L;
    List<Account> accounts = new ArrayList<>();
    private String id;
    private String name;

    public Customer(String customerId, String name) throws CustomerIdNotValidException {
        if (!Validator.validateCustomerId(customerId)) {
            throw new CustomerIdNotValidException("ID: " + customerId + " khong hop le");
        }
        this.id = customerId;
        this.name = name;
    }

    //Tạo một hàm khởi tạo Customer(List<String> values)
    // để phục vụ việc đọc dữ liệu từ file text
    public Customer(List<String> values) throws CustomerIdNotValidException {
        this(values.get(0), values.get(1));
    }

    //Phương thức getAccounts() lấy ra những account có customerId bằng customerId hiện tại.
// Phương thức này sử dụng stream.filter để lọc từ danh sách account lấy từ file.
    public List<Account> getAccounts() {
        return AccountDao.list()
                .stream()
                .filter(account -> account.getCustomerId().equals(id))
                .collect(Collectors.toList());
    }

    //Phương thức displayInformation() Hiển thị thông tin của customer,
// thông tin các tài khoản của customer (lấy tài khoản từ phương thức getAccounts).
    public void displayInformation() {
        accounts = getAccounts();
        String premium = "Normal";

        if (this.isPremium()) {
            premium = "Premium";
        }
        //System.out.println(id + " | " + name + " | " + premium + " | " + String.format("%,.0f", getTotalAccountBalance()) + "đ");
        System.out.printf("%s | %-20s | %-7s | %,16.0f đ\n", id, name, premium, getTotalAccountBalance());
        int accCount = 1;
        //duyệt list và hiển thị tất cả account của khách hàng
        if (accounts != null && !accounts.isEmpty()) {
            for (Account account : accounts) {
                System.out.format("%-5d %s\n", accCount, account.toString());
                accCount++;
            }
        }
    }

    public void displayTransaction() {
        displayInformation();
        for (Account account : accounts
        ) {
            account.displayTransactionsList();
        }
    }

    public boolean addAccount(Account newAccount) {
        accounts = getAccounts();
        //nếu account chưa tồn tại
        // => thêm account mới vào customer
        if (!isAccountExisted(newAccount.getAccountNumber())) {
            accounts.add(newAccount);
            return true;
        }
        System.out.println("Tai khoan da ton tai,them tai khoan khong thanh cong!!");
        return false;
    }

    //Phương thức isAccountExisted(List<Account> accountsList, Account newAccount)
// kiểm tra một account đã tồn tại trong mảng không.
    public boolean isAccountExisted(String accountNumber) {
        List<Account> accountsList = AccountDao.list();
        return accountsList.stream().anyMatch(a -> a.getAccountNumber().equals(accountNumber));
    }

    //Phương thức getAccountByAccountNumber(List<Account> accounts, String accountNumber)
// lấy ra account từ trong danh sách.
    public Account getAccountByAccountNumber(List<Account> accounts, String accountNumber) {
        if (accounts != null && !accounts.isEmpty()) {
            for (Account account : accounts) {
                if (account.getAccountNumber().equals(accountNumber))
                    return account;
            }
        }
        System.out.println("Tai khoan khong ton tai");
        return null;
    }

    //Phương thức displayTransactionInformation() hiển thị thông tin customer,
// thông tin các tài khoản và thông tin các giao dịch của khách hàng hiện tại.
    public void displayTransactionInformation() {
        displayInformation();
        if (accounts != null && !accounts.isEmpty()) {
            for (Account account : accounts) {
                account.displayTransactionsList();
            }
        }
    }

    //Phương thức withdraw(Scanner scanner) yêu cầu nhập số tài khoản
// (lấy danh sách accounts từ getAccounts() để kiểm tra xem tài khoản có tồn tại hay không),
// nhập số tiền rút sau đó gọi hàm rút tiền của account.
    public boolean withdraw() {
        displayInformation();
        if (!accounts.isEmpty()) {
            Account account;
            double amount;
            do {
                String accountNumber = Validator.accountInput();
                if (accountNumber.equals("exit")) {
                    return false;
                }
                account = getAccountByAccountNumber(accounts, accountNumber);
            } while (account == null);
            amount = Validator.amountInput();
            if (account instanceof SavingAccount) {
                return ((SavingAccount) account).withdraw(amount, isPremium());
            }
        }
        System.out.println("Khach hang khong co tai khoan nao");
        return false;
    }

    //Phương thức tranfers(Scanner scanner) yêu cầu nhập tài khoản dùng để chuyển tiền,
    // nhập tài khoản nhận tiền (kiểm tra tính hợp lệ của từng tài khoản),
    // sau đó yêu cầu nhập số tiền rút,
    // xác nhận việc chuyển tiền và sau khi thỏa mãn hết các điều kiện
    // sẽ gọi hàm transfer của account gửi.
    public boolean tranfers() {
        displayInformation();
        if (!accounts.isEmpty()) {
            Account account;
            Account receiveAccount;
            double amount;
            do {
                String accountNumber = Validator.accountInput();
                if (accountNumber.equals("exit")) {
                    return false;
                }
                account = getAccountByAccountNumber(accounts, accountNumber);
            } while (account == null);
            do {
                System.out.println("Nhap so tai khoan nhan(exit de thoat)");
                String receiveAccountNumber = Validator.accountInput();
                if (receiveAccountNumber.equals("exit")) {
                    return false;
                }
                receiveAccount = getAccountByAccountNumber(AccountDao.list(), receiveAccountNumber);
            } while (receiveAccount == null);

            amount = Validator.amountInput();
            if (account instanceof SavingAccount) {
                return ((SavingAccount) account).transfer(receiveAccount, amount, isPremium());
            }
        }
        System.out.println("Khach hang khong co tai khoan nao");
        return false;
    }

    public boolean isPremium() {
        //1 khách hàng là premium nếu có ít nhất 1 tài khoản (Account) là premium
        //duyệt list nếu có một account là premium thì isPremium = "Premium"
        //trả về isPremium
        boolean isPremium = false;
        if (accounts != null && !accounts.isEmpty()) {
            for (Account account : accounts) {
                if ((account instanceof SavingAccount) && account.isPremium()) {
                    isPremium = true;
                }
            }
        }
        return isPremium;
    }

    public double getTotalAccountBalance() {
        //duyệt list và tính tổng tất cả các account balance của khách hàng
        //trả về kết quả
        double totalBalance = 0;
        if (accounts == null) {
            return 0;
        } else {
            for (Account acc : accounts) {
                totalBalance += acc.getBalance();
            }
        }
        return totalBalance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
