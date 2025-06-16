import java.util.Scanner; 
import java.util.Random;


public class GuessTheNumberGame {
    public static void main(String[] args) {
       Scanner scanner= new Scanner(System.in);

       boolean playAgain;
       System.out.println("Welcome to Guess the Number Game!");
       
       do{
        int difficulty = chooseDifficulty(scanner);
        int maxNumber =0;
        int maxAttempts =0;

        if (difficulty ==1){
            maxNumber= 10;
            maxAttempts=5;
        } else if(difficulty ==2){
            maxNumber=50;
            maxAttempts= 7;
        } else {
            maxNumber= 100;
            maxAttempts= 10;
        }
        playGame(scanner,maxNumber,maxAttempts);
        playAgain =askToPlayAgain();

       } while (playAgain);
       System.out.println("Thank you for a game! Goodbye!");
       scanner.close();
    
    }
    public static int chooseDifficulty(){
        return 0;
// max number and max attempts
    }
    public static void playGame(int maxNumber,int maxAttempts){
        //Main game loop
    }
    public static void giveHint(int guess, int target){
        //Hint functionality caldo/freddo
    }
    public static boolean askToPlayAgain(){
        return true;
        //ask if user wants to play again
    }
}