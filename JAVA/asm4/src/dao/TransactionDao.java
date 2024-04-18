package dao;

import file.BinaryFileService;
import model.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao {
    //Quy định tên file dùng để lưu dữ liệu
    private final static String FILE_PATH = "store/transactions.dat";

    //Lưu danh sách Transaction vào file. Input là danh sách Transaction.
    public static boolean save(List<Transaction> transactions) {
        return BinaryFileService.writeFile(FILE_PATH, transactions);
    }

    //Lấy ra danh sách Transaction từ file. Output là danh sách Transaction.
    public static List<Transaction> list() {
        try {
            List<Transaction> list = BinaryFileService.readFile(FILE_PATH);
            if (!list.isEmpty() && list.get(0) instanceof Transaction) {
                return list;
            } else {
                return new ArrayList<>();
            }
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
