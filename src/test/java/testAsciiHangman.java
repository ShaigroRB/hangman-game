import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testAsciiHangman {
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
