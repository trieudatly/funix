package test;

import file.TextFileService;
import org.junit.Test;

import java.io.FileNotFoundException;

public class TextFileServiceTest {

    @Test(expected = IndexOutOfBoundsException.class)
    public void readWrongFile() throws FileNotFoundException {
        TextFileService.readFile("src/test/testCustomers.txt");
    }

    @Test(expected = FileNotFoundException.class)
    public void FileNotFound() throws FileNotFoundException {
        TextFileService.readFile("src/test/testCustomers");
    }
}