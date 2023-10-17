package models;

import java.util.UUID;

public class Transaction {

    private String id;
    private String accountNumber;
    private double amount;
    private double transactionFee;
    private String time;
    private boolean status;


    public Transaction(String accountNumber, double amount, double transactionFee, boolean status) {
        this.id = String.valueOf(UUID.randomUUID());
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionFee = transactionFee;
        this.status = status;
        this.time = Utility.getDateTime();
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

    public boolean isStatus() {
        return status;
    }

    //    public String toString() {
//        return "[GD] " + getAccountNumber() + " | Thoi diem: " + String.format("%s", getTime())
//                + " | So tien: " + String.format("%,.0f", ((-1) * getAmount()))
//                + "đ | Phi: " + String.format("%,.0f", (getTransactionFee())) + "đ | Trang thai: "
//                + String.format("%s", isStatus() ? "Thanh cong" : "Khong thanh cong") + " | Ma giao dich: " + getId() + " |\n";
//    }
    public String toString() {
        return " [GD] " + getAccountNumber()
                + " | " + String.format("%s", getTime())
                + String.format("%s", isStatus() ? " | Thanh cong      " : " | Khong thanh cong")
                + " | " + getId() + " | "
                + String.format("%,.0f", ((-1) * getAmount())) + " đ";
    }
}
