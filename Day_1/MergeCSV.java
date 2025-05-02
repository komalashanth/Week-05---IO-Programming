import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";

        Map<String, String[]> studentInfoMap = new HashMap<>();

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1))) {
            String line1 = br1.readLine(); // skip header
            while ((line1 = br1.readLine()) != null) {
                String[] parts = line1.split(",");
                studentInfoMap.put(parts[0], parts); // ID is key
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            FileWriter writer = new FileWriter(outputFile)
        ) {
            writer.write("ID,Name,Age,Marks,Grade\n");
            String line2 = br2.readLine(); // skip header

            while ((line2 = br2.readLine()) != null) {
                String[] parts2 = line2.split(",");
                String id = parts2[0];
                String[] info1 = studentInfoMap.get(id);

                if (info1 != null) {
                    String mergedLine = String.join(",", info1) + "," + parts2[1] + "," + parts2[2];
                    writer.write(mergedLine + "\n");
                }
            }

            System.out.println("Merged file created successfully: " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

