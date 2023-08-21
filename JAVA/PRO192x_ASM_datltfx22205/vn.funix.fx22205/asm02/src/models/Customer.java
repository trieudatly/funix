package models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private List<Account> accounts;

    public Customer() {
        this.accounts = new ArrayList<>();
        addAcount();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String isPremium() {
        String isPremium = getBanlance() >= 10000000 ? "Premium" : "Normal";
        return isPremium;
    }

    public void addAcount() {
        Account acc = new Account();
        accounts.add(acc);
    }

    public double getBanlance() {
        double totalBanlance = 0;
        for (Account acc : accounts
        ) {
            totalBanlance += acc.getBalance();
        }
        return totalBanlance;
    }

    public void displayinformation() {
        System.out.println(getCustomerId() + " | " + getName() + " | " + isPremium() + " | " + String.format("%,.0f", getBanlance()) + "đ");
        for (Account acc : accounts
        ) {
            System.out.println(acc.toString());
        }
    }
}
