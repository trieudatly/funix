package file;

import exception.CustomerIdNotValidException;
import model.Customer;

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
    static List<List<String>> readFiles(String fileName) {
        List<List<String>> customers = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader(fileName));
            while (scanner.hasNextLine()) {
                String input = "";
                List<String> customer = new ArrayList<>();
                try {
                    input = scanner.nextLine();
                    String[] data = input.split(COMMA_DELIMITER);
                    customer.add(data[0]);
                    customer.add(data[1]);
                } catch (Exception e) {
                    System.out.println("Loi doc file ");
                }
                customers.add(customer);
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
