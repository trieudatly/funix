package models;

public class DigitalBank extends Bank {
//    private static final Scanner sc = new Scanner(System.in);
//    private static final Scanner input = new Scanner(System.in);

    public Customer getCustomerById(String customerId) {
        for (Customer customer : getCustomers()
        ) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public boolean withdraw(String customerId, String accountNumber, double amount) {
        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            Account acc = customer.getAccountByAccounNumber(accountNumber);
            if (acc != null) {
                if (acc.getAccountType().equals("savings")) {
                    SavingsAccount sa = (SavingsAccount) acc;
                    return sa.withdraw(amount);
                } else {
                    LoanAccount la = (LoanAccount) acc;
                    return la.withdraw(amount);
                }
            } else {
                System.out.println("Khong tim thay so account nay!!");
                return false;
            }
        } else {
            System.out.println("Khong tim thay khach hang nay!!");
            return false;
        }
    }

//    public boolean transfers(String customerId) {
//        Customer cus = getCustomerById(customerId);
//        if (cus != null) {
//            cus.displayInformation();
//            System.out.println("Nhap so tai khoan: ");
//            String accNumber = sc.nextLine();
//            Account acc1 = cus.getAccountByAccounNumber(accNumber);
//            if (acc1 != null) {
//                System.out.println("Nhap tai khoan nhan: ");
//                String receiveAccNumber = sc.nextLine();
//
//                for (Customer customer : this.getCustomers()) {
//                    for (Account acc : customer.getAccounts()) {
//                        if (receiveAccNumber.equals(acc.getAccountNumber())) {
//                            customer.displayInformation();
//                            Account acc2 = acc;
//                            System.out.println("Nhap so tien: ");
//                            double amount = input.nextDouble();
//                            System.out.print("Xac nhan thuc hien chuyen " + amount + "d tu tai khoan [" + accNumber + "] den tai khoan [" + receiveAccNumber + "] (Y/N): ");
//                            String xacThuc = sc.nextLine();
//                            if (xacThuc.equals("N") || xacThuc.equals("n")) {
//                                return false;
//                            } else if (xacThuc.equals("Y") || xacThuc.equals("y")) {
//                                SavingsAccount sa = (SavingsAccount) acc1;
//                                //sa.transfers(acc2, amount);
//                                //AccountDAO.update(acc1);
//                                //AccountDAO.update(acc2);
//                                return true;
//                            } else {
//                                System.out.println("Chi nhap 'y' hoac 'n' de xac thuc");
//                                return false;
//                            }
//                        }
//                    }
//                }
//                System.out.println("Khong tim thay so account nay!!");
//                return false;
//            } else {
//                System.out.println("Khong tim thay so account nay!!");
//                return false;
//            }
//        }
//        System.out.println("Khong tim thay khach hang nay!!");
//        return false;
//    }

}
