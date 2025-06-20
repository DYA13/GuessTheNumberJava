package logic;

public class HintGenerator {

    public static void giveHint(int guess, int target, int previousGuess, int maxNumber) {
        if (guess == target)
            return;

        int distance = Math.abs(guess - target);
        if (previousGuess == -1) {
            System.out.println(getClosenessFeedback(distance, maxNumber));
        } else {
            int previousDistance = Math.abs(previousGuess - target);
            if (distance < previousDistance) {
                System.out.println("Warmer 🌡️");
            } else if (distance > previousDistance) {
                System.out.println("Colder 🥶");
            } else {
                System.out.println("No change ❄️");
            }
        }
    }

    public static String getClosenessFeedback(int distance, int maxNumber) {
        if (maxNumber <= 10) {
            if (distance == 1)
                return "🔥 Hot!";
            else if (distance == 2)
                return "🌡️ Warm";
            else if (distance <= 4)
                return "😐 Lukewarm";
            else if (distance <= 6)
                return "🥶 Cold";
            else
                return "❄️ Freezing!";
        } else {
            double percent = distance * 100.0 / maxNumber;
            if (percent <= 10)
                return "🔥 Hot!";
            else if (percent <= 20)
                return "🌡️ Warm";
            else if (percent <= 40)
                return "😐 Lukewarm";
            else if (percent <= 60)
                return "🥶 Cold";
            else
                return "❄️ Freezing!";
        }
    }
}
