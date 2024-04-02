package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SavingAccount extends Account implements Serializable, Withdraw, ReportService {

    //Phương thức withdraw(double amount) kiểm tra điều kiện rút tiền (quy định ở các asm trước),
    // nếu hợp lệ thì gọi phương thức tạo mới giao dịch và cập nhật số dư của tài khoản,
    // nếu không hợp lệ thì trả về thông báo.
    @Override
    public boolean withdraw(double amount, boolean isPremium) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateTime = dateFormat.format(date);
        String accountNumber = this.getAccountNumber();
        //nếu khoản rút được chấp nhận
        //tính toán balance còn lại sau khi rút
        //tạo một transaction mới với thông tin giao dịch thành công
        //dùng log để hiện thông tin giao dịch
        if (isAccepted(amount, isPremium)) {
            double fee = getFee(amount, isPremium);
            double newBalance = getBalance() - amount - fee;
            new Transaction(accountNumber, TransactionType.WITHDRAW, amount, true, dateTime);
            setBalance(newBalance);
            System.out.println("Giao dich thanh cong");
            log(dateTime, accountNumber, amount, newBalance, fee);
            return true;
        }
        //nếu khoản rút không được chấp nhận
        System.out.println("Giao dich khong thanh cong");
        return false;
    }

    public boolean isAccepted(double amount, boolean isPremium) {
//khoản rút phải >= 50 000
        //là bội số của 10 000
        // < 100 000 000
        //tài khoản phải còn >=50 000 nếu rút thành công
        if (amount % 10000 != 0) {
            System.out.println("So tien rut phai la boi so cua 10 000");
            return false;
        }
        if (amount < ACCOUNT_MIN_WITHDRAW) {
            System.out.println("So tien rut toi thieu la: " + ACCOUNT_MIN_WITHDRAW);
            return false;
        }
        if (!isPremium() && amount > SAVINGS_ACCOUNT_MAX_WITHDRAW) {
            System.out.println("So tien toi da co the rut: " + SAVINGS_ACCOUNT_MAX_WITHDRAW);
            return false;
        }
        double newBalance = getBalance() - amount - getFee(amount, isPremium);
        if (newBalance < ACCOUNT_MIN_BALANCE) {
            System.out.println("So du hien tai khong du");
            return false;
        }
        return true;
    }

    public double getFee(double amount, boolean isPremium) {
        //tùy theo tài khoản premium hoặc normal tính mức phí tương ứng
        if (isPremium) {
            return SAVINGS_ACCOUNT_WITHDRAW_PREMIUM_FEE * amount;
        } else {
            return SAVINGS_ACCOUNT_WITHDRAW_FEE * amount;
        }
    }

    //Phương thức transfers(Account receiveAccount, double amount)
// kiểm tra điều kiện chuyển tiền (giống điều kiện rút tiền),
// nếu hợp lệ thì tạo một giao dịch trừ tiền của người gửi và giao dịch cộng tiền cho người nhận,
// nếu không hợp lệ thì trả về lỗi.
    public boolean transfers(Account receiveAccount, double amount) {
        return false;
    }

    @Override
    public void log(String dateTime, String accountNumber, double amount, double newBalance, double fee) {
        System.out.println("+------+-----------------------+------+");
        System.out.println("      BIEN LAI GIAO DICH SAVINGS       ");
        System.out.printf("NGAY GIAO DICH: %22s%n", dateTime);
        System.out.printf("ATM ID: %30s%n", "DIGITAL-BANK-ATM 2023");
        System.out.printf("SO TAI KHOAN SAVINGS: %16s%n", accountNumber);
        System.out.printf("SO TIEN: %27s%s%n", String.format("%,.0f", ((-1) * amount)), " đ");
        System.out.printf("SO DU: %29s%s%n", String.format("%,.0f", newBalance), " đ");
        System.out.printf("PHI + VAT: %25s%s%n", String.format("%,.0f", fee), " đ");
        System.out.println("+------+-----------------------+------+");
    }
}
