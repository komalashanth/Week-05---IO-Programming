import java.sql.*;
import java.io.FileWriter;
import java.io.IOException;

public class ExportToCSV {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";

        String csvFile = "employees_report.csv";

        String query = "SELECT id, name, department, salary FROM employees";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            FileWriter writer = new FileWriter(csvFile)
        ) {
            writer.write("Employee ID,Name,Department,Salary\n");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                writer.write(id + "," + name + "," + department + "," + salary + "\n");
            }

            System.out.println("CSV report generated: " + csvFile);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

