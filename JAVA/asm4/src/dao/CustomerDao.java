package dao;

import file.BinaryFileService;
import model.Customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    /**
     * Quy định tên file dùng để lưu dữ liệu của customers
     */
    private final static String FILE_PATH = "store/customers.dat";

    /**
     * Lưu danh sách khách hàng vào file. Input là danh sách khách hàng.
     */
    public static boolean save(List<Customer> customers) {
        if (customers == null) {
            return false;
        }
        return BinaryFileService.writeFile(FILE_PATH, customers);
    }

    /**
     * Lấy ra danh sách khách hàng từ file.
     * Output là danh sách khách hàng.
     */
    public static List<Customer> list() {
        //kiểm tra đối tượng đọc được từ file có thật sự thuộc class Customer hay ko
        //nếu không phải hoặc xảy ra lỗi đọc file thì sẽ trả về 1 list rỗng
        try {
            List<Customer> list = BinaryFileService.readFile(FILE_PATH);
            if (!list.isEmpty() && list.get(0) instanceof Customer) {
                return list;
            } else {
                return new ArrayList<>();
            }
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
