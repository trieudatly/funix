package models;

import exception.CustomerIdNotValidException;
import service.CustomerIdValidator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer extends User implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Account> accounts;

    public Customer(String Id, String name, List<Account> accounts) {
        super(Id, name);
        this.accounts = accounts;
    }

    public Customer(String customerId, String name) throws CustomerIdNotValidException {
        if (!CustomerIdValidator.validateCustomerId(customerId)) {
            throw new CustomerIdNotValidException("ID khong hop le");
        }
        this.setUserId(customerId);
        this.setName(name);
        this.accounts = new ArrayList<>();
    }

    public Customer() {
        super();
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public boolean isPremium() {
        //1 khách hàng là premium nếu có ít nhất 1 tài khoản (Account) là premium
        //duyệt list nếu có một account là premium thì isPremium = "Premium"
        //trả về isPremium
        boolean isPremium = false;
        if (accounts == null || accounts.isEmpty()) {
            isPremium = false;
        }//nếu duyệt hết list mà không có account premium thì isPremium = "Normal"
        else {
            for (Account account : this.accounts) {
                if ((account instanceof SavingAccount) && account.isPremium()) {
                    isPremium = true;
                }
            }
        }
        return isPremium;
    }

    public Account getAccountByAccountNumber(String accountNumer) {
        for (Account account : accounts) {
            // Kiem tra account co ton tai hay khong
            if (account.getAccountNumber().equals(accountNumer)) {
                return account;
            }
        }
        return null;
    }

    public Account getAccountByAccountNumber(List<Account> accounts, String accountNumer) {
        for (Account account : accounts) {
            // Kiem tra account co ton tai hay khong
            if (account.getAccountNumber().equals(accountNumer)) {
                return account;
            }
        }
        return null;
    }

    public void displayTransactionInformation() {

    }

    //    public boolean withdraw(Scanner scanner){
//        List<Account> accounts=getAccounts();
//        if(!accounts.isEmpty()){
//            Account account;
//            double amount;
//            do{
//                System.out.println("Nhap so tai khoan: ");
//                account=getAccountByAccountNumber(accounts,scanner.nextLine());
//            }while(account==null);
//            do{
//                System.out.println("Nhap so tien rut: ");
//                amount=Double.parseDouble(scanner.nextLine());
//            }while(amount<=0);
//            if(account instanceof SavingAccount){
//                ((SavingAccount) account).withdraw(amount);
//            }else {
//                System.out.println("Khach hang khong co tai khoan nao, thao tac khong thanh cong");
//            }
//        }
//        return false;
//    }
    public boolean tranfers(Scanner scanner) {
        return false;
    }

    public void addAccount() {
        while (true) {
            //nhập accountNumber thông qua phương thức accountNumberInput() của class Account
            String accountInput = Account.accountNumberInput();
            //nếu account chưa tồn tại
            // => thêm account mới với accountNumber vừa nhập vào customer
            //thoát vòng lặp
            if (!isExisted(accountInput)) {
                accounts.add(new Account(accountInput, Account.amountInput()));
                break;
            } else {
                //nếu account đã tồn tại => thông báo
                System.out.println("tai khoan da ton tai");
            }
        }
    }

    public boolean addAccount(Account newAccount) {
        //nếu account chưa tồn tại
        // => thêm account mới vào customer
        if (accounts == null) {
            return false;
        }
        if (accounts.isEmpty()) {
            accounts.add(newAccount);
            System.out.println("Them tai khoan thanh cong!!");
            return true;
        }
        for (Account account : accounts) {
            if (newAccount.getAccountNumber().equals(account.getAccountNumber())) {
                System.out.println("Tai khoan da ton tai,them tai khoan khong thanh cong!!");
                return false;
            }
        }
        accounts.add(newAccount);
        System.out.println("Them tai khoan thanh cong!!");
        return true;
    }


    public boolean isExisted(String accountNumber) {
        //nếu list trống coi account chưa tồn tại
        //trả về false
        if (accounts.isEmpty()) {
            return false;
        }
        //duyệt list
        //nếu có account với accountNumber tương đương tham số
        //trả về true
        for (Account account : accounts) {
            if (accountNumber.equals(account.getAccountNumber())) {
                return true;
            }
        }
        //trả về false nếu duyệt hết list mà không tìm thấy accountNumber nào tương đương
        return false;
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

    public void displayInformation() {
        String premium = "Normal";
        if (this.isPremium()) {
            premium = "Premium";
        }
        System.out.println(getCustomerId() + " | " + getName() + " | " + premium + " | " + String.format("%,.0f", getTotalAccountBalance()) + "đ");
        int accCount = 1;
        //duyệt list và hiển thị tất cả account của khách hàng
        if (accounts != null && !accounts.isEmpty()) {
            for (Account account : accounts) {
                System.out.format("%-5s %8s\n", accCount, account.toString());
                accCount++;
            }
        }

    }

    @Override
    public String toString() {
        return "Customer{" +
                "accounts=" + accounts +
                '}';
    }
}
