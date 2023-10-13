package models;

public class DigitalCustomer extends Customer {
    public DigitalCustomer(String name, String customerID) {
        super(name, customerID);
    }

    @Override
    public void displayInformation() {
        String isPre = "normal";
        if (isPremium().equals("Premium")) {
            isPre = "Premium";
        }
        System.out.printf("%-15s | %-20s | %-15s | %.1fđ\n", getCustomerId(), getName(), isPre, getBalance());
        for (int i = 0; i < getAccounts().size(); i++) {
            System.out.printf("%-15s | %-20s | %15s\t\n", i + 1, getAccounts().get(i).toString());
        }
    }
}