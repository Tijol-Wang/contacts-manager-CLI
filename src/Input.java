import java.util.Scanner;

public class Input {
    private Scanner scanner; //final? static?

    public Input() {
        scanner = new Scanner(System.in);
    }

    public String getString() {
        return scanner.nextLine();
    }

    public String getString(String prompt) {
        System.out.print(prompt);
        return getString();
    }

    public boolean yesNo() {
        String userConfirmation = scanner.nextLine().toLowerCase();
        return userConfirmation.equals("y") || userConfirmation.equals("yes");
    }

    public boolean yesNo(String prompt) {
        System.out.println(prompt);
        return yesNo();
    }

    public int getInt(int min, int max) {
        while (true) {
            System.out.println("Enter an integer between " + min + " and " + max + ": ");
            int userInput; // int userInput = getInt();
            try {
                userInput = Integer.parseInt(getString().trim());
            } catch (RuntimeException e) {
                System.err.println("Must enter an integer: ");
                return getInt(min, max);
            }
            if (userInput >= min && userInput <= max)
                return userInput;
        }
    }

    public int getInt(int min, int max, String prompt) {
        System.out.println(prompt);
        return getInt(min, max);
    }

    public int getInt() {
        try {
            return Integer.parseInt(getString().trim());
        } catch (NumberFormatException e) {
            System.out.println("\033[0;31m" + e.toString() + "\033[0m");
//            System.out.println(e.getMessage());
//            e.printStackTrace();
            return getInt("Error, Enter an integer: ");
        }
    }

    public int getInt(String prompt) {
        System.out.println(prompt);
        return getInt();
    }

    public long getLong() {
        try {
            return Long.parseLong(getString().trim());
        } catch (NumberFormatException e) {
            System.out.println("\033[0;35m" + e.toString() + "\033[0m");
//            System.out.println(e.getMessage());
//            e.printStackTrace();
            return getInt("Error, Enter an long: ");
        }
    }

    public long getLong(String prompt) {
        System.out.println(prompt);
        return getLong();
    }

    public double getDouble(double min, double max) {
        while (true) {
            System.out.println("Enter a float point number between " + min + " and " + max + ": ");
            double userInput;
            try {
                userInput = Double.parseDouble(getString().trim());
            } catch (RuntimeException e) {
                System.err.println("Must enter a float number: ");
                return getDouble(min, max);
            }
            if (userInput >= min && userInput <= max)
                return userInput;
        }
    }

    public double getDouble(double min, double max, String prompt) {
        System.out.println(prompt);
        return getDouble(min, max);
    }

    public double getDouble() {
        try {
            return Double.parseDouble(getString().trim());
        } catch (NumberFormatException e) {
            System.out.println("\033[0;31m" + e.toString() + "\033[0m");
//            System.out.println(e.getMessage());
//            e.printStackTrace();
            return getDouble("Error, Enter a float point number: ");
        }
    }

    public double getDouble(String prompt) {
        System.out.println(prompt);
        return getDouble();
    }

    public int getBinary() {
        System.out.println("Enter a binary number: ");
        try {
            return Integer.parseInt(getString().trim(), 2);
        } catch (NumberFormatException e) {
            System.out.println("\033[0;33m" + e.toString() + "\033[0m");
//            System.out.println(e.getMessage());
//            e.printStackTrace();
            System.out.println("Error");
            return getBinary();
        }
    }

    public int getHex() {
        System.out.println("Enter a hexadecimal number: ");
        try {
            return Integer.parseInt(getString().trim(), 16);
        } catch (NumberFormatException e) {
            System.out.println("\033[0;35m" + e.toString() + "\033[0m");
//            System.out.println(e.getMessage());
//            e.printStackTrace();
            System.out.println("Error");
            return getHex();
        }
    }
}
