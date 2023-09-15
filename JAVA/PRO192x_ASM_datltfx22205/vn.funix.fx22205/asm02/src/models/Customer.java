package models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private List<Account> accounts;

    public Customer(String name, String cusID) {
        super(name, cusID);
        this.accounts = new ArrayList<>();
    }

    public Customer() {
        super();
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String isPremium() {
        String isPremium = getBanlance() >= 10000000 ? "Premium" : "Normal";
        return isPremium;
    }

    public void addAccount() {
        int accountCheck = 0;
        String accountInput = "";
        while (accountCheck == 0) {
            accountInput = Account.accountInput();
            if (accounts.size() == 0) {
                break;
            }
            for (Account account : accounts
            ) {
                if (accountInput.equals(account.getAccountNumber())) {
                    System.out.println("tai khoan da ton tai");
                    accountCheck = 0;
                    break;
                } else {
                    accountCheck++;
                }
            }
        }
        accounts.add(new Account(accountInput));

    }

    public void addAccount(Account acc) {
        //Account acc = new Account();
        accounts.add(acc);
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
        System.out.println(getCustomerId() + " | " + getName() + " | " + isPremium() + " | " + String.format("%,.0f", getBanlance()) + "đ");
        int accCount = 1;
        for (Account acc : accounts
        ) {
            System.out.format("%-5s %8s", accCount, acc.toString());
            System.out.println();
            accCount++;
        }
    }
}
