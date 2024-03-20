import java.io.*;
import java.util.ArrayList;
import java.util.List;

class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private int userId;
    private String userName;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}

class Customer extends User implements Serializable {
    private int cusId;

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public Customer(int userId, String userName, int cusId) {
        super(userId, userName);
        this.cusId = cusId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId=" + getUserId() +
                ", userName='" + getUserName() + '\'' +
                ", cusId=" + cusId +
                '}';
    }
}

public class CustomerSerialization {

    public static void writeCustomersToFile(List<Customer> customers, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(customers);
            System.out.println("List of Customer objects has been written to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> readCustomersFromFile(String fileName) {
        List<Customer> customers = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            customers = (List<Customer>) in.readObject();
            System.out.println("List of Customer objects has been read from " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static void main(String[] args) {List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(1, "Alice", 1001));
        customerList.add(new Customer(2, "Bob", 1002));

       // writeCustomersToFile(customerList, "customerList.dat");

        List<Customer> readCustomers = readCustomersFromFile("customerList.dat");
        for (Customer customer : readCustomers) {
            System.out.println(customer);
        }
    }
}