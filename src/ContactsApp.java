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

        System.out.println("\n" +
                " _    _        _                               _ \n" +
                "| |  | |      | |                             | |\n" +
                "| |  | |  ___ | |  ___  ___   _ __ ___    ___ | |\n" +
                "| |/\\| | / _ \\| | / __|/ _ \\ | '_ ` _ \\  / _ \\| |\n" +
                "\\  / \\ /|  __/| || (__| (_) || | | | | ||  __/|_|\n" +
                " \\/  \\/  \\___||_| \\___|\\___/ |_| |_| |_| \\___|(_)"

                                                                 );
        try {

            displayMenu();

            // To Empty List
//            Files.write(dataFilePath, new ArrayList<>());
//            System.out.println("After empty");
//            FileIO.printFileContents(dataFilePath);

        } catch (IOException ex) {
            System.out.println("Cannot create file");
            ex.printStackTrace();
        }
    }

    public static void displayMenu() throws IOException {
        Path dataFilePath = FileIO.createDirectoryAndFile(fileName);
        int userChoice;
        do {
            System.out.println("\n"  +
                    "Personal Contact Manager App\n" + "\n" +
                    "1. View contacts.\n" +
                    "2. Add a new contact.\n" +
                    "3. Search a contact by name.\n" +
                    "4. Delete an existing contact.\n" +
                    "5. Exit.\n"
                    );

            switch (userChoice = input.getInt(1,5)) {
                case 1 -> FileIO.printFileContents(dataFilePath);
                case 2 -> addContact();
                case 3 -> searchContact();
                case 4 -> deleteContact();
                case 5 -> System.out.println("\n" +
                        " _____  _____  _____ ______ ______ __   __ _____  _ \n" +
                        "|  __ \\|  _  ||  _  ||  _  \\| ___ \\\\ \\ / /|  ___|| |\n" +
                        "| |  \\/| | | || | | || | | || |_/ / \\ V / | |__  | |\n" +
                        "| | __ | | | || | | || | | || ___ \\  \\ /  |  __| | |\n" +
                        "| |_\\ \\\\ \\_/ /\\ \\_/ /| |/ / | |_/ /  | |  | |___ |_|\n" +
                        " \\____/ \\___/  \\___/ |___/  \\____/   \\_/  \\____/ (_)\n");
            }
        } while (!(userChoice == 5));
    }

    public static void addContact() throws IOException {
        Path dataFilePath = FileIO.createDirectoryAndFile(fileName);
        String name = input.getString("Enter new contact name: ");
        FileIO.verifyUserInput(dataFilePath, name);
    }

    public static void deleteContact() throws IOException{
        Path dataFilePath = FileIO.createDirectoryAndFile(fileName);
        String name = input.getString("Who would you like to remove?: ");
        FileIO.deleteLine(dataFilePath, name);
    }

    public static void searchContact() throws IOException{
        Path dataFilePath = FileIO.createDirectoryAndFile(fileName);
        String name = input.getString("Who would you like to search?: ");
        FileIO.searchLine(dataFilePath, name);
    }
}


