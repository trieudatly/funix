package test;

import file.BinaryFileService;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryFileServiceTest {

    @Test(expected = IOException.class)
    public void readFileNotFound() throws IOException {
        BinaryFileService.readFile("src/test/fileNotFound.dat");
    }

    @Test(expected = IOException.class)
    public void readNotDataFile() throws IOException {
        BinaryFileService.readFile("src/test/testCustomers.txt");
    }

    @Test
    public void writeFile() {
        assertTrue(BinaryFileService.writeFile("src/test/testWriteFile.dat", new ArrayList<>()));
        assertFalse(BinaryFileService.writeFile("src/test/", new ArrayList<>()));
    }
}