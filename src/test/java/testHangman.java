import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testHangman {
    private Hangman hangman;

    @Before
    public void setup() {
        hangman = new Hangman();
        hangman.setWord("dog");
    }

    void sameLetterForLoops(String letter, int loops) {
        for (int i = 0; i < loops; i++) {
            hangman.giveLetter(letter);
        }
    }

    @Test(timeout = 5000)
    public void lineFromWordCat() {
        hangman.setWord("cat");
        Assert.assertEquals("_ _ _", hangman.wordToLine());
    }

    @Test(timeout = 5000)
    public void lineFromWordTower() {
        hangman.setWord("tower");
        Assert.assertEquals("_ _ _ _ _", hangman.wordToLine());
    }

    @Test(timeout = 5000)
    public void onlyWrongLetters() {
        while (!(hangman.isEndOfGame())) {
            hangman.giveLetter("a");
        }
        Assert.assertEquals(9, hangman.getTurn());
        Assert.assertEquals(true, hangman.isGameOver());
    }

    @Test(timeout = 5000)
    public void oneGoodLetter() {
        hangman.giveLetter("o");
        while (!(hangman.isEndOfGame())) {
            hangman.giveLetter("a");
        }
        Assert.assertEquals(10, hangman.getTurn());
        Assert.assertEquals(true, hangman.isGameOver());
    }

    @Test(timeout = 5000)
    public void onlyGoodLetters() {
        while (!(hangman.isEndOfGame())) {
            hangman.giveLetter("d");
            hangman.giveLetter("o");
            hangman.giveLetter("g");
        }
        Assert.assertEquals(3, hangman.getTurn());
        Assert.assertEquals(false, hangman.isGameOver());
    }

    @Test(timeout = 5000)
    public void lineFromOneGoodLetter() {
        hangman.giveLetter("o");
        Assert.assertEquals("_ o _", hangman.wordToLine());
        Assert.assertEquals(false, hangman.isEndOfGame());
        Assert.assertEquals(false, hangman.isGameOver());
    }

    @Test(timeout = 5000)
    public void lineFromOneGoodLetterMultipleOccurences() {
        hangman.setWord("foo");
        hangman.giveLetter("o");
        Assert.assertEquals("_ o o", hangman.wordToLine());
    }

    @Test(timeout = 5000)
    public void letterNotExisting() {
        Assert.assertEquals(LETTER_VALIDITY.INVALID_LETTER, hangman.giveLetter("a"));
    }

    @Test(timeout = 5000)
    public void letterExisting() {
        Assert.assertEquals(LETTER_VALIDITY.VALID_LETTER, hangman.giveLetter("o"));
    }

    @Test(timeout = 5000)
    public void wordGivenInsteadOfLetter() {
        Assert.assertEquals(LETTER_VALIDITY.NOT_A_LETTER, hangman.giveLetter("dog"));
    }

    @Test(timeout = 5000)
    public void asciiHangmanOnePenalization() {
        hangman.giveLetter("a");
        Assert.assertEquals("___", hangman.getAscii());
    }

    @Test(timeout = 5000)
    public void asciiHangmanTwoPenalizations() {
        sameLetterForLoops("a", 2);
        Assert.assertEquals(" | " + System.lineSeparator() + "_|_", hangman.getAscii());
    }

    @Test(timeout = 5000)
    public void asciiHangmanThreePenalizations() {
        sameLetterForLoops("a", 3);
        Assert.assertEquals("  __" + System.lineSeparator() + " | " + System.lineSeparator() + "_|_",
                hangman.getAscii());
    }

    @Test(timeout = 5000)
    public void asciiHangmanFourPenalizations() {
        sameLetterForLoops("a", 4);
        Assert.assertEquals(
                "  __" + System.lineSeparator() + " |/ " + System.lineSeparator() + "_|_",
                hangman.getAscii());
    }

    @Test(timeout = 5000)
    public void asciiHangmanFivePenalizations() {
        sameLetterForLoops("a", 5);
        Assert.assertEquals(
                "  __" + System.lineSeparator() + " |/ |" + System.lineSeparator() + "_|_"
                , hangman.getAscii());
    }

    @Test(timeout = 5000)
    public void asciiHangmanSixPenalizations() {
        sameLetterForLoops("a", 6);
        Assert.assertEquals(
                "  __" + System.lineSeparator() + " |/ |" + System.lineSeparator() + "_|_ O",
                hangman.getAscii());
    }

    @Test(timeout = 5000)
    public void asciiHangmanSevenPenalizations() {
        sameLetterForLoops("a", 7);
        Assert.assertEquals(
                "  __" + System.lineSeparator() + " |/ |"
                        + System.lineSeparator() + "_|_ O" + System.lineSeparator() + "    |",
                hangman.getAscii());
    }

    @Test(timeout = 5000)
    public void asciiHangmanEightPenalizations() {
        sameLetterForLoops("a", 8);
        Assert.assertEquals(
                "  __" + System.lineSeparator() + " |/ |" + System.lineSeparator() + "_|_ O"
                        + System.lineSeparator() + "   /|\\",
                hangman.getAscii());
    }

    @Test(timeout = 5000)
    public void asciiHangmanNinePenalizations() {
        sameLetterForLoops("a", 9);
        Assert.assertEquals(
                "  __" + System.lineSeparator() + " |/ |"
                        + System.lineSeparator() + "_|_ O"
                        + System.lineSeparator() + "   /|\\"
                        + System.lineSeparator() + "   / \\",
                hangman.getAscii());
    }
}
