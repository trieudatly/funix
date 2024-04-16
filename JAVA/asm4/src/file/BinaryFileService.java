package file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//File BinaryFileService định nghĩa lớp có chức năng cung cấp các dịch vụ đọc/ghi file nhị phân.
public class BinaryFileService {
    /**
     * đọc file nhị phân. Đầu vào là đường dẫn đến thư mục, đầu ra là danh sách đối tượng.
     */
    public static <T> List<T> readFile(String fileName) throws IOException {
        List<T> objects = new ArrayList<>();
        try (ObjectInputStream file = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            boolean eof = false;
            while (!eof) {
                try {
                    T object = (T) file.readObject();
                    objects.add(object);
                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch (EOFException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Loi doc file");
            throw new IOException();
        } catch (ClassNotFoundException e) {
            System.out.println("Loi doc file");
        }
        return objects;
    }

    /**
     * ghi file nhị phân.nhận đầu vào là đường dẫn đến thư mục và danh sách đối tượng cần lưu.
     */
    public static <T> boolean writeFile(String fileName, List<T> objects) {
        try (ObjectOutputStream file = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            for (T object : objects) {
                file.writeObject(object);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
