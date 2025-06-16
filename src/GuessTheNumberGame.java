import java.util.Scanner; 
import java.util.Random;


public class GuessTheNumberGame {
    public static void main(String[] args) {
       Scanner scanner= new Scanner(System.in);

       boolean playAgain;
       System.out.println("Welcome to Guess the Number Game!");
       
       do{
        int difficulty = chooseDifficulty(scanner);
        int maxNumber = 0;
        int maxAttempts = 0;

        if (difficulty == 1){
            maxNumber = 10;
            maxAttempts = 5;
        } else if(difficulty == 2){
            maxNumber = 50;
            maxAttempts = 7;
        } else {
            maxNumber = 100;
            maxAttempts = 10;
        }
        playGame(scanner,maxNumber,maxAttempts);
        playAgain = askToPlayAgain();

       } while (playAgain);
       System.out.println("Thank you for a game! Goodbye!");
       scanner.close();
    
    }
    public static int chooseDifficulty(Scanner scanner){
        System.out.println("Please choose the level of difficulty:");
        System.out.println("1 -Easy(numbers from 1 to 10)");
        System.out.println("2- Medium(numbers from 1 to 50)");
        System.out.println("3- Hard(numbers from 1 to 100)");
      
        int difficulty = scanner.nextInt();
        while (difficulty <1 ||difficulty>3){
            System.out.println(" Please enter the level 1,2 or 3");
            difficulty=scanner.nextInt();


        }

        return difficulty;

    }
    public static void playGame(Scanner scanner,int maxNumber,int maxAttempts){
        //Main game loop
    }
    public static void giveHint(int guess, int target){
        //Hint functionality caldo/freddo
    }
    public static boolean askToPlayAgain(Scanner scanner){
        return true;
        //ask if user wants to play again
    }
}