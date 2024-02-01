package models;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserTest {
    User user = new User("00121500000", "FUNIX");

    @Test
    public void validateCustomerId() {
        //một CustomerId hợp lệ có 12 số bất kì từ 0-9
        assertFalse(user.validateCustomerId("0012150000000"));//thừa 1 số
        assertFalse(user.validateCustomerId("00121500000"));//thiếu 1 số
        assertFalse(user.validateCustomerId("00121500000a"));//có chữ
        assertFalse(user.validateCustomerId("-00121500000"));//có ký tự đặc biệt
        assertTrue(user.validateCustomerId("001215000001"));//hợp lệ
    }
}