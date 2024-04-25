package model;

public interface IReport {
    void log(String dateTime, TransactionType type, String withdrawAccountNumber, String receiveAccountNumber, double amount, double newBalance, double fee);
}
