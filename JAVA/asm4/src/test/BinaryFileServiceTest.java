package test;

import file.BinaryFileService;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryFileServiceTest {
    /**
     * Không tìm thấy file
     */
    @Test(expected = IOException.class)
    public void readFileNotFound() throws IOException {
        BinaryFileService.readFile("src/test/fileNotFound.dat");
    }

    /**
     * File không phải dạng data binary
     */
    @Test(expected = IOException.class)
    public void readNotDataFile() throws IOException {
        BinaryFileService.readFile("src/test/testCustomers.txt");
    }

    @Test
    public void writeFile() {
        //ghi file thành công
        assertTrue(BinaryFileService.writeFile("src/test/testWriteFile.dat", new ArrayList<>()));
        //ghi file không thành công do tên file không phù hợp
        assertFalse(BinaryFileService.writeFile("src/test/", new ArrayList<>()));
    }
}