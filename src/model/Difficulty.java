package model;

import util.InputUtils;
import java.util.Scanner;

public record Difficulty(int maxNumber, int maxAttempts) {

    public static Difficulty choose(Scanner scanner) {
        System.out.println("Please choose the level of difficulty:");
        System.out.println("1 - Easy (1 to 10)");
        System.out.println("2 - Medium (1 to 50)");
        System.out.println("3 - Hard (1 to 100)");

        int choice = InputUtils.getValidatedInt(scanner, 1, 3);

        return switch (choice) {
            case 1 -> new Difficulty(10, 5);
            case 2 -> new Difficulty(50, 7);
            default -> new Difficulty(100, 10);
        };
    }
}
