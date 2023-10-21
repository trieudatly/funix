package models;

public class DigitalBank extends Bank {

    public Customer getCustomerById(String customerId) {
        for (Customer customer : getCustomers()
        ) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public boolean withdraw() {
        Customer customer = getCustomerById(User.cccdInput());
        if (customer == null) {
            System.out.println("Khong ton tai khach hang nay");
            return false;
        }
        Account account = customer.getAccountByAccountNumber(Account.accountNumberInput());
        if (account == null) {
            System.out.println("Khong ton tai tai khoan nay");
            return false;
        }
        double amount = Account.balanceInput();
        if (account.getAccountType().equals("savings")) {
            SavingsAccount savingsAccount = (SavingsAccount) account;
            return savingsAccount.withdraw(amount);
        } else {
            LoanAccount loanAccount = (LoanAccount) account;
            return loanAccount.withdraw(amount);
        }
    }

    public boolean withdraw(String customerId) {
        Customer customer = getCustomerById(customerId);
        if (customer == null) {
            System.out.println("Khong ton tai khach hang nay");
            return false;
        }
        Account account = customer.getAccountByAccountNumber(Account.accountNumberInput());
        if (account == null) {
            System.out.println("Khong ton tai tai khoan nay");
            return false;
        }
        double amount = Account.balanceInput();
        if (account.getAccountType().equals("savings")) {
            SavingsAccount savingsAccount = (SavingsAccount) account;
            return savingsAccount.withdraw(amount);
        } else {
            LoanAccount loanAccount = (LoanAccount) account;
            return loanAccount.withdraw(amount);
        }
    }
}


