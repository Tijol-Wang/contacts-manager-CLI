import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactsApp {


    public static void main(String[] args) {
        String fileName = "contacts.txt";
        Contact Jack = new Contact("Jack Black", 1231231234);
        Contact Sara = new Contact("Sara Tee", 1231231233);
        Contact Rose = new Contact("Rose Titanic", 1231231232);
        Contact Li = new Contact("Li Wha", 1231231237);

        try {
            Path dataFilePath = FileIO.createDirectoryAndFile(fileName);

            // Let's write to our file
            List<String> contactList = Arrays.asList(Jack.getName() + " " + Jack.getNum(), Sara.getName(), "bacon");
            Files.write(dataFilePath, contactList);

            // Let's read our file
            // Now, let's refactor the loop above
            FileIO.printFileContents(dataFilePath);

            // Append to the file. StandardOpenOption.APPEND will prevent overwriting
//            Files.write(dataFilePath, Arrays.asList("cereal", "bread"), StandardOpenOption.APPEND);
//            FileIO.printFileContents(dataFilePath);

            // To edit our file
            // 1. Read a file in.
            // 2. then, replace a line on file
//            FileIO.updateLine(dataFilePath, "milks", "whole milk");
//            FileIO.printFileContents(dataFilePath);

            // Remove a line from the file
//            FileIO.deleteLine(dataFilePath, "bread");
//            FileIO.printFileContents(dataFilePath);

            // To Empty List
//            Files.write(dataFilePath, new ArrayList<>());
//            System.out.println("After empty");
//            FileIO.printFileContents(dataFilePath);

        } catch (IOException ex) {
            System.out.println("Cannot create file");
            ex.printStackTrace();
        }
    }
}


