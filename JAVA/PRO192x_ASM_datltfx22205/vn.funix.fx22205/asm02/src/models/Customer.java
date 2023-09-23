package models;

import java.util.ArrayList;
import java.util.List;

//class Customer kế thừa class User
public class Customer extends User {
    private List<Account> accounts;

    public Customer() {
        super();
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
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

    public String isPremium() {
        //1 khách hàng là premium nếu có ít nhất 1 tài khoản (Account) là premium
        //duyệt list nếu có một account là premium thì isPremium = "Premium"
        //trả về isPremium
        String isPremium = "Normal";
        for (Account acc : accounts
        ) {
            if (acc.isPremium()) {
                isPremium = "Premium";
                return isPremium;
            }
        }
        //nếu duyệt hết list mà không có account premium thì isPremium = "Normal"
        return isPremium;
    }

    public double getBanlance() {
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
        System.out.println(getCustomerId() + " | " + getName() + " | " + isPremium() + " | " + String.format("%,.0f", getBanlance()) + "đ");
        int accCount = 1;
        //duyệt list và hiển thị tất cả account của khách hàng
        for (Account acc : accounts
        ) {
            System.out.format("%-5s %8s", accCount, acc.toString());
            System.out.println();
            accCount++;
        }
    }
}
