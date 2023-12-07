package models;

public class DigitalCustomer extends Customer {

    public DigitalCustomer(String customerId, String name) {
        super(customerId, name);
    }

    public boolean withdraw() {
        //yêu cầu nhập accountNumber
        Account account = super.getAccountByAccountNumber(Account.accountNumberInput());
        //nếu tài khoản không tồn tại return false
        if (account == null) {
            System.out.println("Khong ton tai tai khoan nay");
            return false;
        }
        //yêu cầu nhập số tiền cần rút
        double amount = Account.amountInput();
        //kiểm tra tài khoản Premium hay normal
        boolean isPremium = super.isCustomerPremium();
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