import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    public static Path createDirectoryAndFile(String fileName) throws IOException {
        Path dataFilePath = Paths.get(fileName);

        if (!Files.exists(dataFilePath)) {
            Files.createFile(dataFilePath);
        }
        return dataFilePath;
    }

    public static void printFileContents(Path filePath) throws IOException {
        System.out.println();
        List<String> fileContents = Files.readAllLines(filePath);
        for (int i = 0; i < fileContents.size(); i++) {
            System.out.printf("%s\n", fileContents.get(i));
        }
    }

    public static void updateLine(Path filePath, String oldValue, String newValue) throws IOException {
        List<String> fileContents = Files.readAllLines(filePath);
        List<String> modifiedList = new ArrayList<>();
        for (String item : fileContents) {
            // TODO: Add my modified item
            if (item.equals("milks")) {
                modifiedList.add("whole milk");
            } else {
                // TODO: Add the existing item bec it isn't what we want to replace.
                modifiedList.add(item);
                //System.out.println("did not find that item");
            }
            Files.write(filePath, modifiedList);
        }
    }

    public static void deleteLine(Path filePath, String line) throws IOException{
        List<String> fileContents = Files.readAllLines(filePath);
        List<String> modifiedList = new ArrayList<>(); // cleared it out
        for (String item: fileContents) {
            // TODO: I want to remove bread from the list
            if(!item.equals("bread")) {
                modifiedList.add(item);
            }
        }
        Files.write(filePath, modifiedList);
    }
}
