import java.util.Scanner;
import java.util.Random;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean playAgain;
        System.out.println("Welcome to Guess the Number Game!");

        do {
            int difficulty = chooseDifficulty(scanner);
            int maxNumber = 0;
            int maxAttempts = 0;

            if (difficulty == 1) {
                maxNumber = 10;
                maxAttempts = 5;
            } else if (difficulty == 2) {
                maxNumber = 50;
                maxAttempts = 7;
            } else {
                maxNumber = 100;
                maxAttempts = 10;
            }
            playGame(scanner, maxNumber, maxAttempts);
            playAgain = askToPlayAgain(scanner);

        } while (playAgain);
        System.out.println("Thank you for a game! Goodbye!");
        scanner.close();
    }

    public static int chooseDifficulty(Scanner scanner) {
        System.out.println("Please choose the level of difficulty:");
        System.out.println("1 -Easy(numbers from 1 to 10)");
        System.out.println("2- Medium(numbers from 1 to 50)");
        System.out.println("3- Hard(numbers from 1 to 100)");

        int difficulty = scanner.nextInt();
        while (difficulty < 1 || difficulty > 3) {
            System.out.println(" Please enter the level 1,2 or 3");
            difficulty = scanner.nextInt();
        }

        return difficulty;
    }

    public static void playGame(Scanner scanner, int maxNumber, int maxAttempts) {
        Random random = new Random();
        int target = random.nextInt(maxNumber) + 1;
        int previousGuess = -1;
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.println("Attempt " + attempt + "from" + maxAttempts
                    + "Enter the number from 1 to" + maxNumber + " :");
            int guess = scanner.nextInt();

            if (guess == target) {
                System.out.println(
                        "Congratulations! You guessed the number in " + attempt + " attempts!");

                return;
            } else {
                giveHint(guess, target, previousGuess);
                previousGuess = guess;
            }
        }
        System.out.println("Unfortunatly , you have lost! The number was " + target);
    }

    public static void giveHint(int guess, int target, int prevoiusGuess) {
        int distance = Math.abs(guess - target);
        if (prevoiusGuess == -1) {
            if (distance >= 50)
                System.out.println("Freezing ❄️");
            else if (distance >= 30)
                System.out.println("Very Cold 🧊");
            else if (distance >= 20)
                System.out.println("Cold 🥶");
            else if (distance >= 15)
                System.out.println("Cool");
            else if (distance >= 10)
                System.out.println("Warm 🌡️");
            else if (distance >= 5)
                System.out.println("Hot 🔥");
            else if (distance >= 2)
                System.out.println("Very Hot🔥🔥");
            else
                System.out.println("Sizzling! You're right next to it! 🔥🔥🔥");
        } else {
            int prevoiusDistance = Math.abs(prevoiusGuess - target);
            if (distance < prevoiusDistance) {
                System.out.println("Warmer 🌡️");
            } else if (distance > prevoiusDistance) {
                System.out.println("Colder ❄️");
            } else {
                System.out.println("No changes");
            }
        }
    }

    public static boolean askToPlayAgain(Scanner scanner) {
        System.out.println("Would you like to play again?(yes/no)");
        String response = scanner.nextLine().toLowerCase();
        return response.equals("yes") || response.equals("y");
    }
}
