import java.io.IOException;
import java.nio.file.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static Set<String> listFilesUsingDirectoryStream(String dir) throws IOException, DirectoryIteratorException {
        Set<String> fileSet = new HashSet<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    fileSet.add(path.getFileName().toString());
                }
            }
        }
        return fileSet;
    }

    public static void main(String[] args) {
        String dir = ".";
        Set<String> fileSet;
        {
            try {
                fileSet = listFilesUsingDirectoryStream(dir);
//                for (String fileName : fileSet
//                ) {
//                    System.out.println(fileName);
//                }
                fileSet.forEach(System.out::println);//lamda expression
            } catch (IOException | DirectoryIteratorException e) {
                System.out.println(e.getMessage() + " cannot be accessed");
            }
        }
    }


}