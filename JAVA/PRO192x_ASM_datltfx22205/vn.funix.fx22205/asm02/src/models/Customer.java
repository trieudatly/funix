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

    public void addAcount(Account newAccount) {

    }

    public void getBanlance() {

    }

    public void displayinformation() {

    }
}
