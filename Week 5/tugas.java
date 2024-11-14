import java.util.Scanner;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;

public class tugas {
    private static ArrayList<String> words = new ArrayList<>();
    private static final int MAX_ATTEMP = 6;
    public static void main(String[] args) {
       
        
    }

    public static void masukkanKata(Scanner scanner) {
        System.out.println("Masukkan kata, tidak boleh sama dan minimum 7");
        while (words.size()<5) {
            String word = scanner.nextLine();
            if (word.length() >= 7 && !words.contains(word)){
                words.add(word);
            }   
            else {
                System.out.println("Salah, mohon masukkan minimal 7 huruf");
            }
            
        }


    }

    public static String pilihHurufAcak() {
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
