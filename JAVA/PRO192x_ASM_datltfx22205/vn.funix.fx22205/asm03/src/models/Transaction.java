package models;

import java.util.UUID;

public class Transaction {
    private String id;
    private String accountNumber;
    private double amount;
    private String time;
    private boolean status;


    public Transaction(String accountNumber, double amount, boolean status) {
        this.id = String.valueOf(UUID.randomUUID());
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.status = status;
        this.time = Utility.getDate();
    }

    public String getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public String getTime() {
        return time;
    }

    public boolean isStatus() {
        return status;
    }

    public String toString() {
        return "[GD] " + getAccountNumber() + String.format("%22s", getTime())
                + " | " +
                String.format("%18s", String.format("%,d", (long) ((-1) * getAmount()))) +
                "đ |" + String.format("%12s", isStatus() ? "Thanh cong" : "Khong thanh cong") + "| " + getId() + "\n";
    }
}
