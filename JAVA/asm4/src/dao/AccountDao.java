package dao;

import file.BinaryFileService;
import model.Account;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


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
        //List<Account> updateAccounts = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (Account account : accounts
        ) {
            executor.execute(() -> {
                //System.out.println("theard running");
                int index = checkIndex(editAccount, account, accounts);
                if (index > -1) {
                    accounts.set(index, editAccount);
                    //System.out.println("theard update");
                    executor.shutdownNow();
                }
            });
        }
        executor.shutdown();
        return save(accounts);
    }

    private static Integer checkIndex(Account editAccount, Account account, List<Account> accounts) {
        //System.out.println("theard checking");
        if (account.getAccountNumber().equals(editAccount.getAccountNumber())) {
            return accounts.indexOf(account);
        }
        return -1;
    }

    private void updateList(List<Account> list, int index, Account account) {

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
