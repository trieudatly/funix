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
        double amount = Account.amountInput();
        boolean isPremium = customer.isCustomerPremium();
        if (account.getAccountType().equals("savings")) {
            SavingsAccount savingsAccount = (SavingsAccount) account;
            return savingsAccount.withdraw(amount, isPremium);
        } else {
            LoanAccount loanAccount = (LoanAccount) account;
            return loanAccount.withdraw(amount, isPremium);
        }
    }

    //rút tiền theo customerId
    public boolean withdraw(String customerId) {
        Customer customer = getCustomerById(customerId);
        //nếu customer không tồn tại return false
        if (customer == null) {
            System.out.println("Khong ton tai khach hang nay");
            return false;
        }
        //yêu cầu nhập accountNumber
        Account account = customer.getAccountByAccountNumber(Account.accountNumberInput());
        //nếu tài khoản không tồn tại return false
        if (account == null) {
            System.out.println("Khong ton tai tai khoan nay");
            return false;
        }
        //yêu cầu nhập số tiền cần rút
        double amount = Account.amountInput();
        //kiểm tra tài khoản Premium hay normal
        boolean isPremium = customer.isCustomerPremium();
        //tùy theo loại tài khoản saving hay loan sẽ gọi phương thức tương ứng
        if (account.getAccountType().equals("savings")) {
            SavingsAccount savingsAccount = (SavingsAccount) account;
            return savingsAccount.withdraw(amount, isPremium);
        } else {
            LoanAccount loanAccount = (LoanAccount) account;
            return loanAccount.withdraw(amount, isPremium);
        }
    }
}


