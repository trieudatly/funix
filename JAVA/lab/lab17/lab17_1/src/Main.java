public class Main {
    public static void main(String[] args) {

        final BankAccount account = new BankAccount("12345-678", 1000.00);
        System.out.println(account);
        Thread trThread1 = new Thread() {
            public void run() {
                System.out.println("trThread1 running");
                account.deposit(300);
                account.withdraw(50);
                System.out.println(account);
            }
        };
        Thread trThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("trThread2 running");
                account.deposit(203.75);
                account.withdraw(100);
                System.out.println(account);
            }
        });
        trThread1.start();
        trThread2.start();
    }
}