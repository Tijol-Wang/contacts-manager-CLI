import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileIO {
    static Input input = new Input();

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
        System.out.println(
                "-----------------------------------------\n" +
                "      Name       |    Phone number      |\n" +
                "-----------------------------------------");
        for (int i = 0; i < fileContents.size(); i++) {
            System.out.printf("%s%n", fileContents.get(i));
        }
        System.out.println("-----------------------------------------");
    }

    public static void verifyUserInput(Path filePath, String newValue) throws IOException {
        List<String> fileContents = Files.readAllLines(filePath);
        List<String> newList = new ArrayList<>();
        for (String item : fileContents) {
            if (item.contains(newValue)) {
                newList.add(item);
            }
        }
        if (newList.isEmpty()) {
            long num = input.getLong("Enter new contact number: ");
            FileIO.addLine(filePath, newValue, num);
        } else {
            System.out.println(newValue + " already exists.");
            boolean userChoice = input.yesNo("Do you want to overwrite it? (Yes/No): ");
            if (userChoice) {
                long newNum = input.getLong("Enter the new number for " + newValue + ":");
                String newNumStr = formatter(newValue, newNum);
                updateLine(filePath, newList.get(0), newNumStr);
            } else {
                if (input.yesNo("Okay. Do you want to add another new contact? (Yes/No): ")) {
                    ContactsApp.addContact();
                } else {
                    ContactsApp.displayMenu();
                }
            }
        }
    }

    public static void updateLine(Path filePath, String oldValue, String newValue) throws IOException {
        List<String> fileContents = Files.readAllLines(filePath);
        List<String> modifiedList = new ArrayList<>();
        for (String item : fileContents) {
            // TODO: Add my modified item
            if (item.equals(oldValue)) {
                modifiedList.add(newValue);
            } else {
                // TODO: Add the existing item bec it isn't what we want to replace.
                modifiedList.add(item);
            }
            Files.write(filePath, modifiedList);
        }
    }

    public static List<String> searchLine(Path filePath, String newValue) throws IOException {
        List<String> fileContents = Files.readAllLines(filePath);
        List<String> modifiedList = new ArrayList<>();
        for (String item : fileContents) {
            if (item.contains(newValue)) {
                modifiedList.add(item);
            }
        }
        if (modifiedList.isEmpty()) {
            System.out.println("Sorry, can't find anyone with that name");
        } else {
            System.out.println("Results:");
            for (String item : modifiedList) {
                System.out.println(item);
            }
        }
        return modifiedList;
    }

    public static void deleteLine(Path datafilePath, String line) throws IOException {
        List<String> fileContents = Files.readAllLines(datafilePath);
        List<String> modifiedList = new ArrayList<>(); // cleared it out
        List<String> searchResults = searchLine(datafilePath, line);
        if (searchResults.size() > 1) {
            String specificName = input.getString("Found multiple results. Who would do you want to delete?");
            deleteLine(datafilePath, specificName);
        } else { // size ==1 || 0
            for (String item : fileContents) {
                if (!searchResults.contains(item)) {
                    modifiedList.add(item);
                }
            }
            Files.write(datafilePath, modifiedList);
        }
    }

    public static void addLine(Path dataFilePath, String str, long num) throws IOException {
        String newContact = formatter(str,num);
        Files.write(dataFilePath, Arrays.asList(newContact), StandardOpenOption.APPEND);
    }

    public static String formatter(String name, long num) {
        int length = Long.toString(num).length();
        String numStr;
        if (length < 8) {
            numStr = String.valueOf(num).replaceFirst("(\\d{3})(\\d+)", "$1-$2");
        } else if (length < 11) {
            numStr = String.valueOf(num).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");
        } else {
            numStr = String.valueOf(num).replaceFirst("(\\d)(\\d{3})(\\d{3})(\\d+)", "+$1-$2-$3-$4");
        }
        return String.format("%-15s  |  %-18s  |", name, numStr);
    }
}

