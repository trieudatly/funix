package utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.DigitalBank;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private static GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
    private static Gson gson = builder.create();
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
            System.out.println("List of Customer has been read from " + fileName);
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
            System.out.println("Loi ghi File");
        }
    }
    public static <T>void writeToDataFile(List<T> objects, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(objects);
            System.out.println("List of Customer objects has been written to " + fileName);
        } catch (IOException e) {
            System.out.println("Loi ghi File");
        }
    }
    public static void writeDigitalBankToJSONFile(DigitalBank digitalBank, String fileName) {
        String jsonString = gson.toJson(digitalBank);
        try(FileWriter locFile = new FileWriter(fileName)) {
                locFile.write(jsonString);
        } catch (IOException e) {
            System.out.println("Loi ghi File");
        }
    }
    public static DigitalBank readDigitalBankFromJSONFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Loi doc File");
        }
        return gson.fromJson(content.toString(),DigitalBank.class);

    }
    public static <T>List<T> readFromDataFile(String fileName) {
        List<T> objects = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            objects = (List<T>) in.readObject();
            System.out.println("List of Customer objects has been read from " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Khong tim thay file");
        }
        return objects;
    }

}
