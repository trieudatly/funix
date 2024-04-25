package test;

import org.junit.Test;
import service.Validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatorTest {
    @Test
    public void validateCustomerId() {
        assertTrue(Validator.validateCustomerId("001215000001"));//hợp lệ
        assertFalse(Validator.validateCustomerId("00121500000"));//thiếu số
        assertFalse(Validator.validateCustomerId("0012150000011"));//thừa số
        assertFalse(Validator.validateCustomerId("00121500000a"));//có chữ
        assertFalse(Validator.validateCustomerId("00121500000@"));//có ký tự đặc biệt
    }

}