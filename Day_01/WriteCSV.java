import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("ID,Name,Department,Salary\n");
            writer.append("101,John Doe,IT,60000\n");
            writer.append("102,Jane Smith,HR,55000\n");
            writer.append("103,Emily Davis,Finance,58000\n");
            writer.append("104,Michael Brown,Marketing,53000\n");
            writer.append("105,David Wilson,Operations,62000\n");

            System.out.println("CSV file created successfully at: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

