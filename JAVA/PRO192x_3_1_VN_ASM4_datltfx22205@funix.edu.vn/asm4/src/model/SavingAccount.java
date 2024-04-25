package model;

import dao.AccountDao;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SavingAccount extends Account implements Serializable, IWithdraw, ITransfer, IReport {
    private static final long serialVersionUID = 1L;

    public SavingAccount(String accountNumber, double balance, String customerId) {
        super(accountNumber, balance, customerId);
    }

    /**
     * Kiểm tra điều kiện rút tiền (quy định ở các asm trước),
     * nếu hợp lệ thì gọi phương thức tạo mới giao dịch và cập nhật số dư của tài khoản,
     * nếu không hợp lệ thì in ra thông báo.
     */
    @Override
    public boolean withdraw(double amount, boolean isPremium) {
        String dateTime = getDateTime();
        String accountNumber = this.getAccountNumber();
        //nếu khoản rút được chấp nhận
        //tính toán balance còn lại sau khi rút
        //tạo một transaction mới với thông tin giao dịch thành công
        //dùng log để hiện thông tin giao dịch
        if (isAccepted(amount, isPremium)) {
            double fee = getFee(amount, isPremium);
            double newBalance = getBalance() - amount - fee;
            setBalance(newBalance);
            if (AccountDao.update(this)) {
                createTransaction(accountNumber, TransactionType.WITHDRAW, ((-1) * amount), true, dateTime);
                log(dateTime, TransactionType.WITHDRAW, accountNumber, "", amount, newBalance, fee);
                System.out.println("Giao dich thanh cong");
                return true;
            }
            System.out.println("Giao dich khong thanh cong");
            return false;
        }
        //nếu khoản rút không được chấp nhận
        System.out.println("Giao dich khong thanh cong");
        return false;
    }

    /**
     * kiểm tra điều kiện chuyển tiền (giống điều kiện rút tiền),
     * nếu hợp lệ thì tạo một giao dịch trừ tiền của người gửi và giao dịch cộng tiền cho người nhận,
     * nếu không hợp lệ thì in ra thông báo.
     */
    @Override
    public boolean transfer(Account receiveAccount, Double amount, boolean isPremium) {
        String dateTime = getDateTime();
        String accountNumber = this.getAccountNumber();
        //nếu khoản chuyển được chấp nhận
        //tính toán balance còn lại sau khi chuyển
        //tạo transaction mới với thông tin giao dịch thành công cho cả tài khoản gửi và nhận
        //dùng log để hiện thông tin giao dịch
        if (isAccepted(amount, isPremium)) {
            double fee = getFee(amount, isPremium);
            double newBalance = getBalance() - amount - fee;
            double newReceiveBalance = receiveAccount.getBalance() + amount;
            receiveAccount.setBalance(newReceiveBalance);
            setBalance(newBalance);
            if (AccountDao.update(receiveAccount) && AccountDao.update(this)) {
                createTransaction(accountNumber, TransactionType.TRANSFER, ((-1) * amount), true, dateTime);
                createTransaction(receiveAccount.getAccountNumber(), TransactionType.TRANSFER, amount, true, dateTime);
                log(dateTime, TransactionType.TRANSFER, accountNumber, receiveAccount.getAccountNumber(), amount, newBalance, fee);
                System.out.println("Giao dich thanh cong");
                return true;
            }
            System.out.println("Giao dich khong thanh cong");
            return false;
        }
        //nếu khoản rút không được chấp nhận
        System.out.println("Giao dich khong thanh cong");
        return false;
    }

    /**
     * Trả về chuỗi dạng dd/MM/yyyy HH:mm:ss tại thời điểm phương thức được gọi
     */
    private static String getDateTime() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateTime = dateFormat.format(date);
        return dateTime;
    }

    /**
     * Kiểm tra số tiền giao dịch có được chấp nhận không
     */
    public boolean isAccepted(double amount, boolean isPremium) {
        //khoản rút phải >= 50 000
        //là bội số của 10 000
        // < 100 000 000
        //tài khoản phải còn >=50 000 nếu rút thành công
        if (amount % 10000 != 0) {
            System.out.println("So tien giao dich phai la boi so cua 10 000");
            return false;
        }
        if (amount < ACCOUNT_MIN_WITHDRAW) {
            System.out.println("So tien giao dich toi thieu la: " + ACCOUNT_MIN_WITHDRAW);
            return false;
        }
        if (!isPremium() && amount > SAVINGS_ACCOUNT_MAX_WITHDRAW) {
            System.out.println("So tien toi da co the giao dich: " + SAVINGS_ACCOUNT_MAX_WITHDRAW);
            return false;
        }
        double newBalance = getBalance() - amount - getFee(amount, isPremium);
        if (newBalance < ACCOUNT_MIN_BALANCE) {
            System.out.println("So du hien tai khong du");
            return false;
        }
        return true;
    }

    /**
     * Phương thức để lấy khoản phí cho giao dịch
     */
    public double getFee(double amount, boolean isPremium) {
        //tùy theo tài khoản premium hoặc normal tính mức phí tương ứng
        if (isPremium) {
            return SAVINGS_ACCOUNT_WITHDRAW_PREMIUM_FEE * amount;
        } else {
            return SAVINGS_ACCOUNT_WITHDRAW_FEE * amount;
        }
    }

    /**
     * In ra màn hình chi tiết giao dịch
     */
    @Override
    public void log(String dateTime, TransactionType type, String withdrawAccountNumber, String receiveAccountNumber, double amount, double newBalance, double fee) {
        System.out.println("+------+-----------------------+------+");
        System.out.println("      BIEN LAI GIAO DICH SAVINGS       ");
        System.out.printf("NGAY GIAO DICH: %22s%n", dateTime);
        System.out.printf("ATM ID: %30s%n", "DIGITAL-BANK-ATM 2024");
        System.out.printf("SO TK: %31s%n", withdrawAccountNumber);
        if (type.equals(TransactionType.WITHDRAW)) {
            System.out.printf("SO TIEN RUT: %,23.0f đ%n", amount);
        } else {
            System.out.printf("SO TK NHAN: %26s%n", receiveAccountNumber);
            System.out.printf("SO TIEN CHUYEN: %,20.0f đ%n", amount);
        }
        System.out.printf("SO DU TK: %26s%s%n", String.format("%,.0f", newBalance), " đ");
        System.out.printf("PHI + VAT: %25s%s%n", String.format("%,.0f", fee), " đ");
        System.out.println("+------+-----------------------+------+");
    }

    @Override
    public String toString() {
        //return String.format("%s %-20s %,.0f%s", getAccountNumber(), "| SAVINGS | ", getBalance(), " đ");
        return String.format("%s | SAVINGS              |  %,16.0f đ", getAccountNumber(), getBalance());
    }


}
