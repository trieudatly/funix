package dao;

import file.BinaryFileService;
import model.Account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class AccountDao {

    /**
     * Quy định tên file dùng để lưu dữ liệu
     */
    private final static String FILE_PATH = "store/accounts.dat";

    /**
     * cập nhật số dư cho tài khoản, input la account can update
     */
    public static boolean update(Account editAccount) {
        List<Account> accounts = list();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (Account account : accounts
        ) {
            executor.execute(() -> {
                //System.out.println("theard running");
                int index = -1;
                if (account.getAccountNumber().equals(editAccount.getAccountNumber())) {
                    index = accounts.indexOf(account);
                }
                if (index > -1) {
                    accounts.set(index, editAccount);
                    //System.out.println("theard update");
                }
            });
        }
        executor.shutdown();
        return save(accounts);
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
        try {
            List<Account> list = BinaryFileService.readFile(FILE_PATH);
            if (!list.isEmpty() && list.get(0) instanceof Account) {
                return list;
            } else {
                return new ArrayList<>();
            }
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
