//your job is to create a simple banking application.
//there should be com.funix.lab7_12.Bank class
//it should have an arraylist of Branches
//each com.funix.lab7_12.Branch should have an arraylist of Customers
//The com.funix.lab7_12.Customer class should have an arraylist of Doubles(transactions)
//
//com.funix.lab7_12.Customer:
//Name, and an arraylist of Doubles.
//com.funix.lab7_12.Branch:
//Need to be able to add a new customer and initial transaction amount.
//Also needs to add additional transactions for that suatomer/branch
//Bank:
//Add a new branch
//Add a customer to that branch with initial transaction
//Add a transaction for an existing customer for that branch
//Show a list of customers for a particular branch and optionally a list of their transactions.
//Demonstration autoboxing and unboxing in your code
//Hint: transactions
//add data validation.
//e.g check if exists, or does not exitst, etc.
//think about where you are adding the code to perform certion actions.
package com.funix.lab7_12;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("National Bank");
        bank.addBranch("hochiminh");
        bank.addCustomer("hochiminh", "tim", 50.05);
        bank.addCustomer("hochiminh", "tam", 175.34);
        bank.addCustomer("hochiminh", "thu", 220.12);

        //bank.addBranch("hanoi");
        if (bank.addBranch("hanoi")) {
            System.out.println("Hanoi branch created");
        }
        bank.addCustomer("hanoi", "dan", 12.13);
        bank.addCustomer("hanoi", "dai", 125.12);

        bank.addCustomerTransaction("hochiminh", "tim", 44.22);
        bank.addCustomerTransaction("hochiminh", "tim", 12.44);
        bank.addCustomerTransaction("hochiminh", "tam", 1.65);
        bank.listCustomers("hochiminh", true);
        bank.listCustomers("hanoi", true);
        bank.addBranch("vinh");
        if (!bank.addCustomer("vinh", "brian", 5.53)) {
            System.out.println("Error vinh branch does not exist");
        }
        if (!bank.addBranch("hanoi")) {
            System.out.println("Hanoi branch already exist");
        }
        if (!bank.addCustomerTransaction("hanoi", "fegus", 52.33)) {
            System.out.println("Customer does not exist at branch");
        }
        if (!bank.addCustomer("hanoi", "dan", 12.21)) {
            System.out.println("Customer already exist");
        }
    }
}