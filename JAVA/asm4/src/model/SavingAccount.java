package model;

import java.io.Serializable;

public class SavingAccount extends Account implements Serializable {

    //Phương thức withdraw(double amount) kiểm tra điều kiện rút tiền (quy định ở các asm trước),
    // nếu hợp lệ thì gọi phương thức tạo mới giao dịch và cập nhật số dư của tài khoản,
    // nếu không hợp lệ thì trả về thông báo.
    public boolean withdraw(double amount) {
        return false;
    }
//Phương thức transfers(Account receiveAccount, double amount)
// kiểm tra điều kiện chuyển tiền (giống điều kiện rút tiền),
// nếu hợp lệ thì tạo một giao dịch trừ tiền của người gửi và giao dịch cộng tiền cho người nhận,
// nếu không hợp lệ thì trả về lỗi.
    public boolean transfers(Account receiveAccount, double amount) {
        return false;
    }
}
