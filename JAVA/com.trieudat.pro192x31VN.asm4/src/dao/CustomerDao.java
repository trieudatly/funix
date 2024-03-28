package dao;

import file.BinaryFileService;
import models.Customer;

import java.io.IOException;
import java.util.List;

public class CustomerDao {
    //Quy định tên file dùng để lưu dữ liệu của customers
    private final static String FILE_PATH="store/customers.dat";
    //Lưu danh sách khách hàng vào file. Input là danh sách khách hàng.
    public static void save(List<Customer> customers) throws IOException{
        BinaryFileService.writeFile(FILE_PATH,customers);
    }
    //Lấy ra danh sách khách hàng từ file. Output là danh sách khách hàng.
    public static List<Customer> list(){
        return BinaryFileService.readFile(FILE_PATH);
    }
}
