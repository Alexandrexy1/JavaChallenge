import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> setNums = new HashSet<>(Arrays.asList("Alex", "Ana", "Vitoria", "Joao", "Marcio"));

        setNums.removeIf(x -> x.charAt(0) == 'A' || x.charAt(0) == 'J');
        System.out.println(setNums);
    }
}