import java.util.Random;
import java.util.Scanner;

/** A simple number-guessing game for practicing loops and input validation. */
public class NumberQuest {
    private static final int MIN = 1;
    private static final int MAX = 100;
    private static final int MAX_ATTEMPTS = 7;

    public static void main(String[] args) {
        Random random = new Random();
        int secret = random.nextInt(MAX - MIN + 1) + MIN;
        int attempts = 0;

        System.out.println("=== NumberQuest ===");
        System.out.printf("Guess the secret number from %d to %d.%n", MIN, MAX);
        System.out.printf("You have %d valid guesses.%n", MAX_ATTEMPTS);

        try (Scanner scanner = new Scanner(System.in)) {
            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Your guess: ");
                String line = scanner.nextLine().trim();
                int guess;
                try {
                    guess = Integer.parseInt(line);
                } catch (NumberFormatException ex) {
                    System.out.println("Please enter a whole number.");
                    continue;
                }

                if (guess < MIN || guess > MAX) {
                    System.out.printf("Choose a number between %d and %d.%n", MIN, MAX);
                    continue;
                }

                attempts++;
                if (guess == secret) {
                    System.out.printf("Correct! You found it in %d guess(es).%n", attempts);
                    return;
                }
                System.out.println(guess < secret ? "Too low." : "Too high.");
                System.out.printf("Attempts remaining: %d%n", MAX_ATTEMPTS - attempts);
            }
        }

        System.out.printf("Game over. The number was %d.%n", secret);
    }
}
