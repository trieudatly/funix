package models;

public interface ReportService {
    void log(String dateTime, String accountNumber, double amount, double newBalance, double fee);
}
