package engine;

import logic.HintGenerator;
import util.InputUtils;
import model.Difficulty;

import java.util.Random;
import java.util.Scanner;

public class GameEngine {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to Guess the Number Game!");
        boolean playAgain;

        do {
            Difficulty difficulty = Difficulty.choose(scanner);
            playGame(difficulty);
            playAgain = InputUtils.askToPlayAgain(scanner);
        } while (playAgain);

        System.out.println("Thank you for a game! Goodbye!");
        scanner.close();
    }

    private void playGame(Difficulty difficulty) {
        int target = new Random().nextInt(difficulty.maxNumber()) + 1;
        int previousGuess = -1;

        for (int attempt = 1; attempt <= difficulty.maxAttempts(); attempt++) {
            System.out.println("Attempt " + attempt + " of " + difficulty.maxAttempts()
                    + ". Enter a number from 1 to " + difficulty.maxNumber() + ":");

            int guess = InputUtils.getValidatedInt(scanner, 1, difficulty.maxNumber());

            if (guess == target) {
                String word = (attempt == 1) ? "attempt" : "attempts";
                System.out.println(
                        "🎉 Congratulations! You guessed it in " + attempt + " " + word + "!");
                return;
            }

            HintGenerator.giveHint(guess, target, previousGuess, difficulty.maxNumber());
            previousGuess = guess;
        }

        System.out.println("Unfortunately, you have lost! The number was " + target);
    }
}
