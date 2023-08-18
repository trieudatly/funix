package models;

import java.util.List;

public class Customer extends User {
    private List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public boolean isPremium() {
        return false;
    }

    public void addAcount() {

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
        System.out.println(getCustomerId() + " " + getName() + " " + isPremium() + " " + getBanlance());
        for (Account acc : accounts
        ) {
            System.out.println(acc.toString());
        }
    }
}
