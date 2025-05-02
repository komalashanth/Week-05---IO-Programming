import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateCSV {
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "updated_employees.csv";

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            FileWriter writer = new FileWriter(outputFile)
        ) {
            String line = reader.readLine();
            writer.write(line + "\n");

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String department = parts[2].trim();
                double salary = Double.parseDouble(parts[3].trim());

                if (department.equalsIgnoreCase("IT")) {
                    salary *= 1.10;
                    parts[3] = String.format("%.2f", salary);
                }

                writer.write(String.join(",", parts) + "\n");
            }

            System.out.println("Updated records written to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

