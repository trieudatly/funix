public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer(1000, "Tuan", 20);
        Invoice invoice1 = new Invoice(1000, customer1, 100000);
        System.out.println("Customer name: " + invoice1.getCustomerName());
        System.out.println("Invoice after discount: " + invoice1.getAmountAfterDiscount());
    }
}