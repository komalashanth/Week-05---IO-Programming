import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterCSV {
    public static void main(String[] args) {
        String filePath = "students.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int marks = Integer.parseInt(parts[2]);
                if (marks > 80) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
