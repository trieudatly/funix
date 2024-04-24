package test;

import file.TextFileService;
import org.junit.Test;

import java.io.FileNotFoundException;

public class TextFileServiceTest {
    /**
     * không tìm thấy file
     */
    @Test(expected = FileNotFoundException.class)
    public void FileNotFound() throws FileNotFoundException {
        TextFileService.readFile("src/test/testCustomers");
    }
}