import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String path = "/home/alexandre/Documents/candidates.txt";

        Map<String, Integer> urna = Map.of(
                "Joao", 5003, "Maria", 1290, "Francisco", 7050,
                "Fabricio", 5600, "Julia", 8400, "Guilherme", 7020);

        writeVotesToFile(path, urna);

        Map<String, Integer> consolidatedVotes = consolidateVotes(path);
        System.out.println(consolidatedVotes);
    }

    private static void writeVotesToFile(String path, Map<String, Integer> votes) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for(Map.Entry<String, Integer> entry: votes.entrySet()) {
                bw.write(entry.getKey() + "=" + entry.getValue() + "\n");
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Integer> consolidateVotes(String path) {
        Map<String, Integer> consolidated = new LinkedHashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while(line != null) {
                String[] parts = line.split("=");
                if(parts.length == 2) {
                    String candidate = parts[0].trim();
                    int votes = Integer.parseInt(parts[1].trim());
                    consolidated.put(candidate, consolidated.getOrDefault(candidate, 0) + votes);
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return consolidated;
    }
}