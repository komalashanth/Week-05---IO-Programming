import java.io.*;
import java.util.*;

public class CSVReader {
    public static void main(String[] args) {
        String filePath = "students.csv";  // Specify the path to your CSV file

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header line, if present

            while ((line = br.readLine()) != null) {
                String[] studentDetails = line.split(",");  // Split each line by comma
                if (studentDetails.length == 4) {  // Ensure we have the correct number of columns
                    String id = studentDetails[0].trim();
                    String name = studentDetails[1].trim();
                    String age = studentDetails[2].trim();
                    String marks = studentDetails[3].trim();

                    // Print each student's details
                    System.out.printf("ID: %s, Name: %s, Age: %s, Marks: %s%n", id, name, age, marks);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
