package model;

import java.io.Serializable;
import java.util.UUID;

public class Transaction implements Serializable {
    //Implements Serializable và thuộc tính
    // static final long serialVersionUID để hỗ trợ đọc/ghi object.
    private static final long serialVersionUID = 1L;
    private String id;
    private String accountNumber;
    private double amount;
    private String time;
    private boolean status;
    //Thêm thuộc tính type để đánh dấu giao dịch là nhận tiền, rút tiền hay chuyển tiền.
    // Type có thể là String hoặc Enum: DEPOSIT/WITHDRAW/TRANSFER.
    private TransactionType type;

    public Transaction(String accountNumber, TransactionType type, double amount, boolean status, String dateTime) {
        this.id = String.valueOf(UUID.randomUUID());
        this.type = type;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.status = status;
        this.time = dateTime;
    }

    public boolean isStatus() {
        return status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
                + " | " + getType()
                + "  | " + String.format("%,16.0f", getAmount()) + " đ"
                + " | " + String.format("%s", getTime());
    }
}
