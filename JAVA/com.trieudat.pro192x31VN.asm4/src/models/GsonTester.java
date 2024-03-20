package models;

import utility.FileService;

import java.util.List;

public class GsonTester {
    private static final DigitalBank activeBank = new DigitalBank();
    private static final String CUSTOMER_NAME = "FUNIX";
    private static final String CUSTOMER_ID = "001215000001";

    public static void main(String[] args) {

        DigitalCustomer customer = new DigitalCustomer("001215000001", CUSTOMER_NAME);
        DigitalCustomer customer1 = new DigitalCustomer("001215000002", CUSTOMER_NAME);
        DigitalCustomer customer2 = new DigitalCustomer("001215000003", CUSTOMER_NAME);
        DigitalCustomer customer3 = new DigitalCustomer("001215000004", CUSTOMER_NAME);
        activeBank.addCustomer(customer);
        activeBank.addCustomer(customer1);
        activeBank.addCustomer(customer2);
        activeBank.addCustomer(customer3);
//        SavingAccount savingsAccount = new SavingAccount(Account.accountNumberInput(),Account.amountInput());
//        activeBank.addAccount(CUSTOMER_ID, savingsAccount);
//        LoanAccount loanAccount = new LoanAccount(Account.accountNumberInput());
//        activeBank.addAccount(CUSTOMER_ID, loanAccount);
//        activeBank.withdraw(CUSTOMER_ID);
        FileService.writeDigitalBankToJSONFile(activeBank,"store/customer.txt");
        DigitalBank digitalBank=FileService.readDigitalBankFromJSONFile("store/customer.txt");
        List<Customer> customers=digitalBank.getAllCustomer();
        for (Customer cus:customers
             ) {
            activeBank.addCustomer(cus);
        }

    }
}



