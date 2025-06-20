package util;

import java.util.Scanner;

public class InputUtils {

    public static int getValidatedInt(Scanner scanner, int min, int max) {
        while (true) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                scanner.nextLine();
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max);
                }
            } else {
                System.out.println("Invalid input. Please enter a number!");
                scanner.next();
            }
        }
    }

    public static boolean askToPlayAgain(Scanner scanner) {
        System.out.println("Would you like to play again? (yes/no)");
        while (true) {
            String response = scanner.nextLine().toLowerCase();
            if (response.equals("yes") || response.equals("y"))
                return true;
            if (response.equals("no") || response.equals("n"))
                return false;
            System.out.println("Please enter 'yes' or 'no'");
        }
    }
}
