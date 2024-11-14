
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class newtugas {
    private static final int MAX_ATTEMPTS = 6;
    private static ArrayList<String> words = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;

        do {
            words.clear();
            inputWords(scanner);
            String wordToGuess = selectRandomWord();
            playGame(scanner, wordToGuess);
            System.out.print("Do you want to play again? (Y/N): ");
            playAgain = scanner.next().equalsIgnoreCase("Y");
        } while (playAgain);

        System.out.println("Thank you for playing! Goodbye!");
    }

    private static void inputWords(Scanner scanner) {
        System.out.println("Please enter 5 words, each with at least 7 letters (no spaces, no duplicates):");
        while (words.size() < 5) {
            String word = scanner.nextLine();
            if (word.length() >= 7 && !words.contains(word)) {
                words.add(word);
            } else {
                System.out.println("Invalid input. Please enter a word with at least 7 letters and no duplicates.");
            }
        }
    }

    private static String selectRandomWord() {
        Collections.shuffle(words);
        return words.get(0);
    }

    private static void playGame(Scanner scanner, String wordToGuess) {
        char[] guessedWord = new char[wordToGuess.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }   
        
        int attempts = MAX_ATTEMPTS;
        boolean wordGuessed = false;

        while (attempts > 0 && !wordGuessed) {
            System.out.println("Word to guess: " + String.valueOf(guessedWord));
            System.out.println("Attempts remaining: " + attempts);
            System.out.print("Guess a letter: ");
            char guess = scanner.next().charAt(0);
            scanner.nextLine(); // Clear the buffer

            if (Character.isLetter(guess)) {
                boolean correctGuess = false;
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guess) {
                        guessedWord[i] = guess;
                        correctGuess = true;
                    }
                }

                if (!correctGuess) {
                    attempts--;
                    System.out.println("Wrong guess!");
                } else {
                    System.out.println("Good guess!");
                }

                wordGuessed = String.valueOf(guessedWord).equals(wordToGuess);
            } else {
                System.out.println("Please enter a valid letter.");
            }
        }

        if (wordGuessed) {
            System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
        } else {
            System.out.println("You lost! The word was: " + wordToGuess);
        }
    }
}