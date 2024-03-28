package dao;

import file.BinaryFileService;
import models.Account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    //Quy định tên file dùng để lưu dữ liệu
    private final static String FILE_PATH = "store/accounts.dat";

    //cập nhật số dư cho tài khoản
    public static void update(Account editAccount) throws IOException {
        List<Account> accounts = list();
        boolean hasExist = accounts.stream().anyMatch(account -> account.getAccountNumber().equals(editAccount.getAccountNumber()));
        List<Account> updateAccounts;
        if (!hasExist) {
            updateAccounts = new ArrayList<>(accounts);
            updateAccounts.add(editAccount);
        } else {
            updateAccounts = new ArrayList<>();
            for (Account account : accounts
            ) {
                if (account.getAccountNumber().equals(editAccount.getAccountNumber())) {
                    updateAccounts.add(editAccount);
                } else {
                    updateAccounts.add(account);
                }
            }
        }
        save(updateAccounts);
    }

    //Lưu danh sách Account vào file. Input là danh sách khách hàng.
    public static void save(List<Account> accounts) throws IOException {
        BinaryFileService.writeFile(FILE_PATH, accounts);
    }

    //Lấy ra danh sách Account từ file. Output là danh sách Account .
    private static List<Account> list() {
        return BinaryFileService.readFile(FILE_PATH);
    }
}
