package models;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class Utility {
    static Scanner sc = new Scanner(System.in);

    //nhập thông tin từ bàn phím
    //so khớp theo PATTERN
    public static String getInputWithPattern(String pattern) {
        while (true) {
            String input = sc.nextLine().trim().toLowerCase();
            if (input.compareTo("no") == 0) {
                System.out.println("Bye Bye");
                System.exit(0);
            }
            if (!Pattern.matches(pattern, input)) {
                System.out.print("Khong hop le. Vui long nhap lai:");
            } else {
                return input;
            }
        }
    }

    //lấy ngày giờ
    public static String getDateTime() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(date);
    }

    public static <T> List<T> readFile(String fileName) {
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
        } catch (IOException io) {
            System.out.println("IO Exception: " + io.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
        }
        return objects;
    }

    public static <T> void writeFile(String fileName, List<T> objects) {
        try (ObjectOutputStream file = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            for (T object : objects) {
                file.writeObject(object);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> void printList(List<T> objects) {
        for (T object : objects
        ) {
            System.out.println(object);
        }
    }
}
