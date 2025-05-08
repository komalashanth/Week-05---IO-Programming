import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeCSV {
    public static void main(String[] args) {
        String filePath = "large_file.csv";
        int batchSize = 100;
        int totalRecords = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine(); // skip header

            String[] batch = new String[batchSize];
            int count = 0;

            while ((line = reader.readLine()) != null) {
                batch[count++] = line;
                totalRecords++;

                if (count == batchSize) {
                    processBatch(batch, count);
                    count = 0;
                }
            }

            if (count > 0) {
                processBatch(batch, count);
            }

            System.out.println("Total records processed: " + totalRecords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void processBatch(String[] batch, int count) {
        // Simulated processing
        System.out.println("Processed batch of " + count + " records");
    }
}

