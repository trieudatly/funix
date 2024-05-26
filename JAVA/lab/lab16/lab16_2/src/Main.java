import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        final String ROOTFOLDER=".\\2022_sorted";
        Map<String, List<String>> folderMap = readFileInFolderToMap(ROOTFOLDER);
        // show map
        System.out.println("Show folder map");
        Set<String> set = folderMap.keySet();
        for (String key : set) {
            System.out.println(key + " " + folderMap.get(key));
        }
        createFolderAndMoveFile(ROOTFOLDER,folderMap);
    }
    public static boolean checkFileNameValid(String fileName){
        Pattern p = Pattern.compile("^\\d{4}-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])(.txt)$");
        Matcher m = p.matcher(fileName);
        return m.matches();
    }
    public static Map<String, List<String>>    readFileInFolderToMap(String rootFolder){
        Map<String, List<String>> folderMap = new HashMap<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(rootFolder))) {
            for (Path path : stream) {
                System.out.print("Check item: " + path.getFileName());
                if (!Files.isDirectory(path)) {
                    String fileName = path.getFileName().toString();

                    if (checkFileNameValid(fileName)){

                        System.out.println("--- File valid!");

                        // Tách phần tên thư mục
                        String newFolder = fileName.substring(0, fileName.lastIndexOf("-"));

                        List<String> listFileInFolder = new ArrayList<>();

                        // Nếu thư mục đã tồn tại thì lấy ra danh sách tên các tệp hiện có sau đó add tên mới vào danh sách
                        if (folderMap.containsKey(newFolder)){
                            listFileInFolder = folderMap.get(newFolder);
                        }

                        listFileInFolder.add(fileName);
                        folderMap.put(newFolder, listFileInFolder);

                    } else {
                        System.out.println("--- File invalid will be removed !");
                        Files.delete(path);
                    }
                } else {
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return folderMap;
    }
    public static void createFolderAndMoveFile(String rootFolder, Map<String, List<String>> folderMap){
        // Đọc dữ liệu từ map để tạo thư mục và di chuyển tệp vào thư mục
        for (String newFolder : folderMap.keySet()){
            Path newFolderPath = Paths.get(rootFolder, newFolder);
            try {
                // Tạo thư mục mới

                //
                Files.createDirectory(newFolderPath);
                for (String fileName: folderMap.get(newFolder)){
                    // Di chuyển thư mục

                    //
                    Path oldFilePath = Paths.get(rootFolder, fileName);
                    Path newFilePath = newFolderPath.resolve(fileName);
                    Files.move(oldFilePath, newFilePath);
                    System.out.println("Move file :" + oldFilePath + " ===>  :" + newFilePath);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}