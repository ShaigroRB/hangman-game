import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class FileHandler {
    private final String filename;
    List<String> listWords;

    public FileHandler(String filename) {
        this.filename = filename;
        try {
            listWords = Files.readAllLines(Paths.get(filename));
        } catch (Exception e) {
            System.err.println("Failed to get words from " + filename);
            e.printStackTrace();
        }
    }

    public String getRandomWordFromFile() {
        Random random = new Random();
        int rnd_int = random.nextInt(listWords.size());
        return listWords.get(rnd_int);
    }

}
