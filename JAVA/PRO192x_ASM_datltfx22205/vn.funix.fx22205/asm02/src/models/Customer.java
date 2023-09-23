package models;

import java.util.ArrayList;
import java.util.List;

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
            String accountInput = Account.accountNumberInput();
            if (!isAccountExisted(accountInput)) {
                accounts.add(new Account(accountInput));
                break;
            } else {
                System.out.println("tai khoan da ton tai");
            }
        }
    }

    public boolean isAccountExisted(String accountNumber) {
        if (accounts.isEmpty()) {
            return false;
        }
        for (Account account : accounts
        ) {
            if (accountNumber.equals(account.getAccountNumber())) {
                return true;
            }
        }
        return false;
    }

    public String isPremium() {
        String isPremium = "Normal";
        for (Account acc : accounts
        ) {
            if (acc.isPremium()) {
                isPremium = "Premium";
                return isPremium;
            }
        }
        return isPremium;
    }

    public double getBanlance() {
        double totalBalance = 0;
        for (Account acc : accounts
        ) {
            totalBalance += acc.getBalance();
        }
        return totalBalance;
    }

    public void displayinformation() {
        System.out.println(getCustomerId() + " | " + getName() + " | " + isPremium() + " | " + String.format("%,.3f", getBanlance()) + "đ");
        int accCount = 1;
        for (Account acc : accounts
        ) {
            System.out.format("%-5s %8s", accCount, acc.toString());
            System.out.println();
            accCount++;
        }
    }
}
