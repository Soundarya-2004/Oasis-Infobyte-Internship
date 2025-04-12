import java.util.Scanner;
import java.util.Random;

public class Task_2 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int num, score = 0, attempts = 5;

        System.out.println("Hello!! Welcome to Number Guessing Game");
        System.out.println("Rules of the Number Guessing Game:");
        System.out.println("Random number is generated from the compiler within the range of 1 to 100.");
        System.out.println("You have to guess the number in 5 attempts.");
        System.out.println("Scoring Rules:");
        System.out.println("5 attempts: 10 points");
        System.out.println("4 attempts: 20 points");
        System.out.println("3 attempts: 30 points");
        System.out.println("2 attempts: 40 points");
        System.out.println("1 attempt: 50 points");

        // Generate a random number between 1 and 100
        Random rand = new Random();
        num = rand.nextInt(100) + 1;

        int lowerBound = 1, upperBound = 100; // Bounds for clues
        boolean guessedCorrectly = false;

        for (int i = 1; i <= attempts; i++) {
            System.out.println("Attempt " + i + ": ");
            System.out.println("Guess the number between " + lowerBound + " and " + upperBound + ":");
            int guess = in.nextInt();

            if (guess == num) {
                System.out.println("Congratulations!! You guessed the number in " + i + " attempts.");
                score = (attempts - i + 1) * 10;
                System.out.println("Your score is: " + score);
                guessedCorrectly = true;
                break;
            } else if (guess < num) {
                System.out.println("The number is greater than " + guess);
                lowerBound = Math.max(lowerBound, guess + 1); // Update the lower bound
            } else {
                System.out.println("The number is less than " + guess);
                upperBound = Math.min(upperBound, guess - 1); // Update the upper bound
            }
        }

        if (!guessedCorrectly) {
            System.out.println("Sorry!! You have exhausted all your attempts.");
            System.out.println("The number was: " + num);
        }

        System.out.println("Do you want to play again? (yes/no)");
        String playAgain = in.next();

        while (playAgain.equalsIgnoreCase("yes")) {
            num = rand.nextInt(100) + 1; // Regenerate a random number
            lowerBound = 1;
            upperBound = 100;
            guessedCorrectly = false;

            for (int i = 1; i <= attempts; i++) {
                System.out.println("Attempt " + i + ": ");
                System.out.println("Guess the number between " + lowerBound + " and " + upperBound + ":");
                int guess = in.nextInt();

                if (guess == num) {
                    System.out.println("Congratulations!! You guessed the number in " + i + " attempts.");
                    score = (attempts - i + 1) * 10;
                    System.out.println("Your score is: " + score);
                    guessedCorrectly = true;
                    break;
                } else if (guess < num) {
                    System.out.println("The number is greater than " + guess);
                    lowerBound = Math.max(lowerBound, guess + 1);
                } else {
                    System.out.println("The number is less than " + guess);
                    upperBound = Math.min(upperBound, guess - 1);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry!! You have exhausted all your attempts.");
                System.out.println("The number was: " + num);
            }

            System.out.println("Do you want to play again? (yes/no)");
            playAgain = in.next();
        }

        System.out.println("Thank you for playing the game!!");
        System.out.println("Have a nice day!!");
        in.close(); // Close the scanner
    }
}
