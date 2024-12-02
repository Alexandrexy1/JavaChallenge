import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String path = "/home/alexandre/Documents/phrases.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();

            while(line != null) {
                System.out.println(line);
                line = br.readLine();
            }
            //Hello, World!
            //Hello, Java!
            //Hello, Spring boot!
            //Hello, guys!
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}