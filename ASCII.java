import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
public class ASCII {
    public static void main(String[] args) {
        try {
            // Read the contents of the file into a string
            String asciiArt = new String(Files.readAllBytes(Paths.get("ASCII/ascii-art.txt")));

            // Print the ASCII art
            System.out.println(asciiArt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
