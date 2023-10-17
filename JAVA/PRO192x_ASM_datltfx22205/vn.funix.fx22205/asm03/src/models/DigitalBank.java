package models;

public class DigitalBank extends Bank {
    //    private static final Scanner sc = new Scanner(System.in);
//    private static final Scanner input = new Scanner(System.in);


    public Customer getCustomerById(String digitalCustomerId) {
        for (Customer customer : getCustomers()
        ) {
            if (customer.getCustomerId().equals(digitalCustomerId)) {
                return customer;
            }
        }
        return null;
    }


    public boolean withdraw(String customerId, String accountNumber, double amount) {
        Customer customer = getCustomerById(customerId);
        if (customer == null) {
            System.out.println("Khong tim thay Id khach hang " + customerId);
            return false;
        }
        Account account = customer.getAccountByAccounNumber(accountNumber);
        if (account == null) {
            System.out.println("Khong tim thay tai khoan " + accountNumber);
            return false;
        }
        if (account.getAccountType().equals("savings")) {
            SavingsAccount savingsAccount = (SavingsAccount) account;
            return savingsAccount.withdraw(amount);
        } else {
            LoanAccount loanAccount = (LoanAccount) account;
            return loanAccount.withdraw(amount);
        }
    }
}


