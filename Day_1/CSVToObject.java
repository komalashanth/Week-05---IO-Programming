import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


    

public class CSVToObject {
    public static void main(String[] args) {
        String filePath = "students.csv";
        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine(); // skip header

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int marks = Integer.parseInt(parts[2]);

                students.add(new Student(id, name, marks));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Students:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
