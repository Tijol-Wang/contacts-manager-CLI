import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactsApp {
    static Input input = new Input();
    static String fileName = "contacts.txt";
    static List<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {

        try {
            Path dataFilePath = FileIO.createDirectoryAndFile(fileName);

//            List<String> contactList = Arrays.asList(Jack.getName() + " " + Jack.getNum(), Sara.getName(), "bacon");
//            Files.write(dataFilePath, contactList);
//            List<String> contactInfo = new ArrayList<>();
//            for (Contact a: contacts)
//                contactInfo.add(a.getName() + a.getNum());
//
//            Files.write(dataFilePath, contactInfo);
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

            displayMenu();
            //Files.write(dataFilePath, contactInfo);
        } catch (IOException ex) {
            System.out.println("Cannot create file");
            ex.printStackTrace();
        }

    }

    public static void displayMenu() throws IOException {
        Path dataFilePath = FileIO.createDirectoryAndFile(fileName);
        int userChoice;
        do {
            System.out.println("\n1. View contacts.\n" +
                    "2. Add a new contact.\n" +
                    "3. Search a contact by name.\n" +
                    "4. Delete an existing contact.\n" +
                    "5. Exit.\n"
                    );
            userChoice = input.getInt(1, 5);
            switch (userChoice) {
                case 1 -> FileIO.printFileContents(dataFilePath);
                case 2 -> addContact();
                case 3 -> searchContact();
                case 4 -> deleteContact();
                case 5 -> System.out.println("Bye, have a nice day!");
            }
        } while (!(userChoice == 5));
    }

    public static void addContact() throws IOException {
        Path dataFilePath = FileIO.createDirectoryAndFile(fileName);
        String name = input.getString("Enter contact name: ");
        // check if it already exists
        /* if(exists) {overwrite?}
        answer
        if(answer == yes) {updateLine()}
        if(no) {sout("ok... add another one?")
                if(yes) {addContact()}
                if(no) displayMenu();}
        * */
        FileIO.verifyUserInput(dataFilePath, name);

//        Contact a = new Contact(name, num);
//        contacts.add(a);
    }

    public static void deleteContact() throws IOException{
        Path dataFilePath = FileIO.createDirectoryAndFile(fileName);
        String name = input.getString("Who would you like to remove?");
        FileIO.deleteLine(dataFilePath, name);
    }

    public static void searchContact() throws IOException{
        Path dataFilePath = FileIO.createDirectoryAndFile(fileName);
        String name = input.getString("Who is your mother?");
        FileIO.searchLine(dataFilePath, name);
    }
}


