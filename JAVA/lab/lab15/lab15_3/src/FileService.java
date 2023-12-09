import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService<T> {
    public FileService() {
    }

    public void printList(List<T> companyList) {
        //System.out.println(companyList);
        for (T company : companyList
        ) {
            System.out.println(company);
        }
    }

    public List<T> readFile(String fileName) {
        List<T> companyList = new ArrayList<>();
        try (ObjectInputStream file = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            boolean eof = false;
            while (!eof) {
                try {
                    T object = (T) file.readObject();
                    companyList.add(object);
                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch (IOException io) {
            System.out.println("IO Exception: " + io.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
        }
        return companyList;
    }

    public void writeFile(String fileName, List<T> companyList) {
        try (ObjectOutputStream companyFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            for (T company : companyList) {
                companyFile.writeObject(company);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

