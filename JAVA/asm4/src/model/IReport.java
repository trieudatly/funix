package model;

public interface IReport {
    //Hàm log(double amount, TransactionType type, Account receiveAccount)
    // thêm trường type để hiển thị biên lai giao dịch theo từng trường hợp rút tiền/chuyển tiền.
    void log(double amount, TransactionType type, Account receiveAccount);
}
