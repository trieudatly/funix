package models;

import java.util.UUID;

public class Transaction {

    private String id;
    private String accountNumber;
    private double amount;
    private double transactionFee;
    private String time;
    private boolean status;


    public Transaction(String accountNumber, double amount, double transactionFee, boolean status, String dateTime) {
        this.id = String.valueOf(UUID.randomUUID());
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionFee = transactionFee;
        this.status = status;
        this.time = dateTime;
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

    public double getTransactionFee() {
        return transactionFee;
    }

    public String getTime() {
        return time;
    }

    public boolean getStatus() {
        return status;
    }

    public String toString() {
        return " [GD] " + getAccountNumber()
                + " | " + String.format("%s", getTime())
                + String.format("%s", getStatus() ? " | Thanh cong      " : " | Khong thanh cong")
                + " | " + getId() + " | "
                + String.format("%,.0f", ((-1) * getAmount())) + " đ";
    }
}
