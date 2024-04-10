package dao;

import file.BinaryFileService;
import model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    /**
     * Quy định tên file dùng để lưu dữ liệu
     */
    private final static String FILE_PATH = "store/accounts.dat";

    /**
     * cập nhật số dư cho tài khoản
     */
    public static boolean update(Account editAccount) {
        List<Account> accounts = list();
        List<Account> updateAccounts = new ArrayList<>();
        for (Account account : accounts
        ) {
            if (account.getAccountNumber().equals(editAccount.getAccountNumber())) {
                updateAccounts.add(editAccount);
            } else {
                updateAccounts.add(account);
            }
        }
        return save(updateAccounts);
    }

    /**
     * Lưu danh sách Account vào file. Input là danh sách Account.
     */
    public static boolean save(List<Account> accounts) {
        return BinaryFileService.writeFile(FILE_PATH, accounts);
    }

    /**
     * Lấy ra danh sách Account từ file. Output là danh sách Account .
     */
    public static List<Account> list() {
        return BinaryFileService.readFile(FILE_PATH);
    }
}
