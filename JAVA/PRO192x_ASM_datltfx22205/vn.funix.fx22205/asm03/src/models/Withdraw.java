package models;

public interface Withdraw {
    double SAVINGS_ACCOUNT_MAX_WITHDRAW = 5000000;
    double ACCOUNT_MIN_WITHDRAW = 50000;
    double ACCOUNT_MIN_BALANCE = 50000;
    double LOAN_ACCOUNT_WITHDRAW_FEE = 0.05;
    double LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE = 0.01;

    boolean withdraw(double amount);

    boolean isAccepted(double amount);
}
