import java.util.Scanner;

public class MainHangman {
    public static void main(String... args) {
        Hangman hangman = new Hangman();
        FileHandler fileHandler = new FileHandler("hangman.txt");
        hangman.setWord(fileHandler.getRandomWordFromFile());

        String letter;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println(hangman.wordToLine());
            System.out.println("Enter a letter:");
            letter = in.nextLine();
            LETTER_VALIDITY letterExists = hangman.giveLetter(letter);
            if (letterExists == LETTER_VALIDITY.VALID_LETTER) {
                System.out.println("Good find !");
            } else if (letterExists == LETTER_VALIDITY.INVALID_LETTER) {
                System.out.println("This letter is not in the word !");
            } else {
                System.out.println("This is not a letter !");
            }
            System.out.println(hangman.getAscii());
        } while ((!hangman.isEndOfGame()));
        if (hangman.isGameOver()) {
            System.out.println("You lost !");
        } else {
            System.out.println(hangman.wordToLine());
            System.out.println("You win !");
        }
        in.close();
    }
}
