import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) {
        String filePath = "students.csv";
        Set<String> seenIds = new HashSet<>();
        List<String> duplicates = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String header = reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0].trim();

                if (seenIds.contains(id)) {
                    duplicates.add(line);
                } else {
                    seenIds.add(id);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (duplicates.isEmpty()) {
            System.out.println("No duplicate records found.");
        } else {
            System.out.println("Duplicate records based on ID:");
            for (String dup : duplicates) {
                System.out.println(dup);
            }
        }
    }
}

