package models;

import java.io.Serializable;
import java.util.List;

public class DigitalCustomer extends Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    public DigitalCustomer(String customerId, String name, List<Account> accounts) {
        super(customerId, name, accounts);
    }
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
        boolean isPremium = super.isPremium();
        //tùy theo loại tài khoản saving hay loan sẽ gọi phương thức tương ứng
        if (account.getAccountType().equals("savings")) {
            SavingAccount savingsAccount = (SavingAccount) account;
            return savingsAccount.withdraw(amount, isPremium);
        } else {
            LoanAccount loanAccount = (LoanAccount) account;
            return loanAccount.withdraw(amount, isPremium);
        }
    }
}