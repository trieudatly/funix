package dao;

import file.BinaryFileService;
import models.Transaction;

import java.io.IOException;
import java.util.List;

public class TransactionDao {
    //Quy định tên file dùng để lưu dữ liệu
    private final static String FILE_PATH="store/transactions.dat";
    //Lưu danh sách Transaction vào file. Input là danh sách Transaction.
    public static void save(List<Transaction> transactions) throws IOException {
        BinaryFileService.writeFile(FILE_PATH,transactions);
    }
    //Lấy ra danh sách Transaction từ file. Output là danh sách Transaction.
    public static List<Transaction> list(){
        return BinaryFileService.readFile(FILE_PATH);
    }
}
