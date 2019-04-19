import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class testFileHandler {
    @Test(timeout = 5000)
    public void testValidGetWordFromFile() {
        String tmp_path = "";
        BufferedWriter writer = null;
        try {
            File tmp_file = File.createTempFile("testFileHandler", ".hangman");
            tmp_path = tmp_file.getAbsolutePath();
            writer = Files.newBufferedWriter(Paths.get(tmp_path));
            writer.write("hangman");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileHandler fileHandler = new FileHandler(tmp_path);
        Assert.assertEquals("hangman", fileHandler.getRandomWordFromFile());
    }
}
