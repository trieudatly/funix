package models;

import java.util.ArrayList;
import java.util.List;

//class Customer kế thừa class User
public class Customer extends User {
    private static List<Account> accounts;

    public Customer() {
        super();
        this.accounts = new ArrayList<>();
    }

    public Customer(String customerId, String name) {
        super(customerId, name);
        this.accounts = new ArrayList<>();
    }

    public static boolean isPremium() {
        //1 khách hàng là premium nếu có ít nhất 1 tài khoản (Account) là premium
        //duyệt list nếu có một account là premium thì isPremium = "Premium"
        //trả về isPremium
        for (Account acc : accounts
        ) {
            if ((acc instanceof SavingsAccount) && acc.isPremium()) {
                return true;
            }
        }
        //nếu duyệt hết list mà không có account premium thì isPremium = "Normal"
        return false;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Account getAccountByAccounNumber(String accountNumer) {
        for (Account account : accounts) {
            // Kiem tra account co ton tai hay khong
            if (account.getAccountNumber().equals(accountNumer)) {
                return account;
            }
        }
        return null;
    }

    public void addAccount() {
        while (true) {
            //nhập accountNumber thông qua phương thức accountNumberInput() của class Account
            String accountInput = Account.accountNumberInput();
            //nếu account chưa tồn tại
            // => thêm account mới với accountNumber vừa nhập vào customer
            //thoát vòng lặp
            if (!isAccountExisted(accountInput)) {
                accounts.add(new Account(accountInput));
                break;
            } else {
                //nếu account đã tồn tại => thông báo
                System.out.println("tai khoan da ton tai");
            }
        }
    }

    public void addAccount(Account newAccount) {
        for (int i = 0; i < accounts.size(); i++) {
            if (newAccount.getAccountNumber().equals(accounts.get(i).getAccountNumber())) {
                System.out.println("Tai khoan da ton tai");
                return;
            }
        }
        accounts.add(newAccount);
        System.out.println("Them tai khoan thanh cong!!");
    }

    public boolean isAccountExisted(String accountNumber) {
        //nếu list trống coi account chưa tồn tại
        //trả về false
        if (accounts.isEmpty()) {
            return false;
        }
        //duyệt list
        //nếu có account với accountNumber tương đương tham số
        //trả về true
        for (Account account : accounts
        ) {
            if (accountNumber.equals(account.getAccountNumber())) {
                return true;
            }
        }
        //trả về false nếu duyệt hết list mà không tìm thấy accountNumber nào tương đương
        return false;
    }

    public double getBalance() {
        //duyệt list và tính tổng tất cả các account balance của khách hàng
        //trả về kết quả
        double totalBalance = 0;
        for (Account acc : accounts
        ) {
            totalBalance += acc.getBalance();
        }
        return totalBalance;
    }

    public void displayInformation() {
        String premium = "Normal";
        if (isPremium()) {
            premium = "Premium";
        }
        System.out.println(getCustomerId() + " | " + getName() + " | " + premium + " | " + String.format("%,.0f", getBalance()) + "đ");
        int accCount = 1;
        //duyệt list và hiển thị tất cả account của khách hàng
        for (Account account : accounts
        ) {
            System.out.format("%-5s %8s\n", accCount, account.toString());
//            System.out.println();
            accCount++;
        }
    }
}
