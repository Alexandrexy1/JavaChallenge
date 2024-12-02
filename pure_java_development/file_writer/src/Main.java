import javax.imageio.IIOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] lines = {"Hello, World!", "Hello, Java!", "Hello, Spring boot!", "Hello, guys!"};
        String path = "/home/alexandre/Documents/phrases.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String line: lines) {
                bw.write(line + "\n");
            }
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }
}