package model;

import model.TransactionType;

import java.io.Serializable;
import java.util.UUID;

public class Transaction implements Serializable {
    //Implements Serializable và thuộc tính
    // static final long serialVersionUID để hỗ trợ đọc/ghi object.
    private static final long serialVersionUID = 1L;
    private String id;
    private String accountNumber;
    private double amount;
    private double transactionFee;
    private String time;
    private boolean status;
    //Thêm thuộc tính type để đánh dấu giao dịch là nhận tiền, rút tiền hay chuyển tiền.
    // Type có thể là String hoặc Enum: DEPOSIT/WITHDRAW/TRANSFER.
    private TransactionType type;

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

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    //Hàm toString() hiển thị thêm trường type.
    public String toString() {
        return " [GD] " + getAccountNumber()
                + " | " + String.format("%s", getTime())
                + " | " + getType()
                +" | " + String.format("%s", getStatus() ? " | Thanh cong      " : " | Khong thanh cong")
                + " | " + getId() + " | "
                + String.format("%,.0f", ((-1) * getAmount())) + " đ";
    }
}
