package file;

import exception.CustomerIdNotValidException;
import models.Customer;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//định nghĩa lớp thao tác với file text
public class TextFileService {
    //định nghĩa dấu phân cách giữa các phần tử trong file.
    private static final String COMMA_DELIMITER = ",";

    //đọc file text. Đầu vào là đường dẫn đến thư mục, đầu ra là danh sách khách hàng.
    public static List<Customer> readFile(String fileName) {
        List<Customer> customers = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader(fileName));
            //scanner.useDelimiter(COMMA_DELIMITER);
            while (scanner.hasNextLine()) {
                String input = "";
                String id = "";
                String name = "";
                try {
                    input = scanner.nextLine();
                    String[] data = input.split(COMMA_DELIMITER);
                    id = data[0];
                    name = data[1];
                } catch (Exception e) {
                    System.out.println("Loi doc file ");
                }
                try {
                    Customer cus = new Customer(id, name);
                    customers.add(cus);
                } catch (CustomerIdNotValidException e) {
                    System.out.println(e.getMessage() + ": " + id);
                }
            }
        } catch (IOException e) {
            System.out.println("Loi doc file ");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return customers;
    }
}
