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
}
