package file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//định nghĩa lớp thao tác với file text
public class TextFileService {
    //định nghĩa dấu phân cách giữa các phần tử trong file.
    private static final String COMMA_DELIMITER = ",";

    /**
     * đọc file text. Đầu vào là đường dẫn đến thư mục, đầu ra là danh sách khách hàng.
     */
    public static List<List<String>> readFile(String fileName) throws FileNotFoundException {
        List<List<String>> customers = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(fileName))) {
            while (scanner.hasNextLine()) {
                String input = "";
                List<String> customer = new ArrayList<>();
                try {
                    input = scanner.nextLine();
                    String[] data = input.split(COMMA_DELIMITER);
                    customer.add(data[0]);
                    customer.add(data[1]);
                    customers.add(customer);
                } catch (IndexOutOfBoundsException e) {
                    //System.out.println("Dong du lieu khong hop le");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Khong tim thay file ");
            throw new FileNotFoundException();
        }
        return customers;
    }
}
