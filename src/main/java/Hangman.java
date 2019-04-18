public class Hangman {
    private final String[] asciiHangman = {"",
            "___",
            " | " + System.lineSeparator() + "_|_",
            "  __" + System.lineSeparator() + " | " + System.lineSeparator() + "_|_",
            "  __" + System.lineSeparator() + " |/ " + System.lineSeparator() + "_|_",
            "  __" + System.lineSeparator() + " |/ |" + System.lineSeparator() + "_|_",
            "  __" + System.lineSeparator() + " |/ |" + System.lineSeparator() + "_|_ O",
            "  __" + System.lineSeparator() + " |/ |" + System.lineSeparator() + "_|_ O"
                    + System.lineSeparator() + "    |",
            "  __" + System.lineSeparator() + " |/ |" + System.lineSeparator() + "_|_ O"
                    + System.lineSeparator() + "   /|\\",
            "  __" + System.lineSeparator() + " |/ |" + System.lineSeparator() + "_|_ O"
                    + System.lineSeparator() + "   /|\\" + System.lineSeparator() + "   / \\"
    };
    private String word;
    private int CurrentTurn = 0;
    private boolean endOfGame = false;
    private int nbPenalizations = 0;
    private String[] blankLetters;
    private int lettersFound = 0;

    public void setWord(String word) {
        this.word = word;
        blankLetters = new String[word.length()];
        for (int i = 0; i < blankLetters.length; i++) {
            blankLetters[i] = "_";
        }
    }

    public String wordToLine() {
        StringBuilder lineFromWord = new StringBuilder();
        for (int i = 0; i < blankLetters.length; i++) {
            lineFromWord.append(blankLetters[i]);
            if (i + 1 < blankLetters.length) {
                lineFromWord.append(" ");
            }
        }
        return lineFromWord.toString();
    }

    public boolean isEndOfGame() {
        return endOfGame;
    }

    public LETTER_VALIDITY giveLetter(final String letter) {
        CurrentTurn++;
        boolean exists = word.contains(letter);
        LETTER_VALIDITY validity = LETTER_VALIDITY.VALID_LETTER;
        if (!exists || letter.length() > 1) {
            nbPenalizations++;
            validity = letter.length() > 1 ? LETTER_VALIDITY.NOT_A_LETTER : LETTER_VALIDITY.INVALID_LETTER;
        } else {
            char chr_letter = letter.charAt(0);
            lettersFound += word.chars().filter(c -> c == chr_letter).count();
            for (int i = 0; i < blankLetters.length; i++) {
                if (word.charAt(i) == chr_letter) {
                    blankLetters[i] = letter;
                }
            }
        }
        if (nbPenalizations == 9 || lettersFound == word.length()) {
            endOfGame = true;
        }
        return validity;
    }

    public int getTurn() {
        return CurrentTurn;
    }

    public boolean isGameOver() {
        boolean gameOver = false;
        if (nbPenalizations == 9) {
            gameOver = true;
        }
        return gameOver;
    }

    public String getAscii() {
        return asciiHangman[nbPenalizations];
    }
}
