import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchEmployee {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine().trim();

        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[1].trim();
                if (name.equalsIgnoreCase(searchName)) {
                    String department = parts[2];
                    String salary = parts[3];
                    System.out.println("Department: " + department);
                    System.out.println("Salary: " + salary);
                    found = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!found) {
            System.out.println("Employee not found.");
        }
    }
}

