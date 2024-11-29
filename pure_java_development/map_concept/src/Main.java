import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws NullPointerException {
        Map<String, String> player = new LinkedHashMap<>();
        player.put("username", "alex");
        player.put("email", "Alex@test.com");
        player.put("password", "******");

        player.remove("phone");

        System.out.println("All player data:");
        for (String key : player.keySet()) {
            System.out.println(key + ": " + player.get(key));
        }

    }
}