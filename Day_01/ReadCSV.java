import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                count++;
            }
            System.out.println("Number of records (excluding header): " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

