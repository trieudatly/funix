package models;

import java.io.Serializable;
import java.util.UUID;

public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;
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

    public void setId(String id) {
        this.id = id;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setTransactionFee(double transactionFee) {
        this.transactionFee = transactionFee;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
