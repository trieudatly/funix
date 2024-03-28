package file;

import models.Customer;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                String id = scanner.nextLine();
                scanner.skip(scanner.delimiter());
                String name = scanner.nextLine();
                Customer cus = new Customer(id, name);
                customers.add(cus);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return customers;
    }
}
