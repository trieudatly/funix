package models;

public class SavingsAccount extends Account implements Withdraw, ReportService {

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public String toString() {
        return String.format("%s %-20s %,.0f%s", getAccountNumber(), "| SAVINGS | ", getBalance(), " đ");
    }


    @Override
    public boolean withdraw(double amount) {
        String dateTime = Utility.getDateTime();
        String accountNumber = this.getAccountNumber();
        if (isAccepted(amount)) {
            double newBalance = getBalance() - amount;
            addTransaction(new Transaction(accountNumber, amount, 0, true, dateTime));
            setBalance(newBalance);
            System.out.println("Giao dich thanh cong");
            log(dateTime, accountNumber, amount, newBalance, 0);
            return true;
        }
        addTransaction(new Transaction(accountNumber, amount, 0, false, dateTime));
        System.out.println("Giao dich khong thanh cong");
        return false;
    }

    @Override
    public boolean isAccepted(double amount) {

        if (amount % 10000 != 0) {
            System.out.println("So tien rut phai la boi so cua 10 000");
            return false;
        }
        if (amount < ACCOUNT_MIN_WITHDRAW) {
            System.out.println("So tien rut toi thieu la: " + ACCOUNT_MIN_WITHDRAW);
            return false;
        }
        if (!isAccountPremium() && amount > SAVINGS_ACCOUNT_MAX_WITHDRAW) {
            System.out.println("So tien toi da co the rut: " + SAVINGS_ACCOUNT_MAX_WITHDRAW);
            return false;
        }
        double newBalance = getBalance() - amount;
        if (newBalance < ACCOUNT_MIN_BALANCE) {
            System.out.println("So du hien tai khong du");
            return false;
        }
        return true;
    }

    @Override
    public void log(String dateTime, String accountNumber, double amount, double newBalance, double fee) {
        System.out.println("+------+-----------------------+------+");
        System.out.println("      BIEN LAI GIAO DICH SAVINGS       ");
        System.out.printf("NGAY GIAO DICH: %22s%n", dateTime);
        System.out.printf("ATM ID: %30s%n", "DIGITAL-BANK-ATM 2023");
        System.out.printf("SO TAI KHOAN SAVINGS: %16s%n", accountNumber);
        System.out.printf("SO TIEN: %27s%s%n", String.format("%,.0f", ((-1) * amount)), " đ");
        System.out.printf("SO DU: %29s%s%n", String.format("%,.0f", newBalance), " đ");
        System.out.printf("PHI + VAT: %25s%s%n", String.format("%,.0f", fee), " đ");
        System.out.println("+------+-----------------------+------+");
    }
}
