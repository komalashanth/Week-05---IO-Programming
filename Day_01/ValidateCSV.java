import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSV {
    public static void main(String[] args) {
        String filePath = "contacts.csv";
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$";
        Pattern emailPattern = Pattern.compile(emailRegex);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String header = reader.readLine();
            String line;
            int row = 1;

            while ((line = reader.readLine()) != null) {
                row++;
                String[] parts = line.split(",");
                if (parts.length < 4) {
                    System.out.println("Row " + row + ": Invalid number of columns");
                    continue;
                }

                String email = parts[2].trim();
                String phone = parts[3].trim();

                boolean valid = true;

                if (!emailPattern.matcher(email).matches()) {
                    System.out.println("Row " + row + ": Invalid email - " + email);
                    valid = false;
                }

                if (!phone.matches("\\d{10}")) {
                    System.out.println("Row " + row + ": Invalid phone number - " + phone);
                    valid = false;
                }

                if (valid) {
                    // Optionally process valid rows here
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

