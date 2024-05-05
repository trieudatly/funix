import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private String accountNumber;
    private Lock lock;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }

    public void deposit(double amount) {
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        try {
            lock.tryLock(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println("Could not get lock");
        }
        try {
            double origBalance = balance;
            balance += amount;
            System.out.printf("STARTING BALANCE: %.0f, DEPOSIT (%.0f)" +
                    " : NEW BALANCE = %.0f%n", origBalance, amount, balance);
        } finally {
            lock.unlock();
        }

    }

    public void withdraw(double amount) {
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        try {
            lock.tryLock(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println("Could not get lock");
        }
        try {
            double origBalance = balance;

            if (amount <= balance) {
                balance -= amount;
                System.out.printf("STARTING BALANCE: %.0f, WITHDRAWAL (%.0f)" +
                        " : NEW BALANCE = %.0f%n", origBalance, amount, balance);
            } else {
                System.out.printf("STARTING BALANCE: %.0f, WITHDRAWAL (%.0f)" +
                        " : INSUFFICIENT FUNDS!", origBalance, amount);
            }
        } finally {
            lock.unlock();
        }


    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
