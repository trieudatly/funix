import java.io.File;

public class Main {
    public static void main(String[] args) {
        String directoryPath = "C:\\filetest"; // Replace with your actual directory path
        String keywordToRemove = "Watch "; // Replace with the keyword you want to remove

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String oldName = file.getName();
                    if(oldName.contains(keywordToRemove)){
                        String newName = oldName.replace(keywordToRemove, "");

                        File newFile = new File(directory, newName);
                        boolean success = file.renameTo(newFile);

                        if (success) {
                            System.out.println("Renamed " + oldName + " to " + newName);
                        } else {
                            System.err.println("Failed to rename " + oldName);
                        }
                    }
                }
            }
        } else {
            System.err.println("Directory not found or empty.");
        }
    }
}