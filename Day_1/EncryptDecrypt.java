import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.*;
import java.util.Base64;
public class EncryptDecrypt {
private static final String SECRET_KEY = &quot;1234567890123456&quot;; // 16-char key for
AES
public static String encrypt(String plainText) throws Exception {
Cipher cipher = Cipher.getInstance(&quot;AES&quot;);
SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), &quot;AES&quot;);
cipher.init(Cipher.ENCRYPT_MODE, key);
byte[] encrypted = cipher.doFinal(plainText.getBytes());

15

return Base64.getEncoder().encodeToString(encrypted);
}
public static String decrypt(String encryptedText) throws Exception {
Cipher cipher = Cipher.getInstance(&quot;AES&quot;);
SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), &quot;AES&quot;);
cipher.init(Cipher.DECRYPT_MODE, key);
byte[] decrypted =
cipher.doFinal(Base64.getDecoder().decode(encryptedText));
return new String(decrypted);
}
public static void writeEncryptedCSV(String filePath) {
List&lt;String[]&gt; students = Arrays.asList(
new String[]{&quot;101&quot;, &quot;Alice&quot;, &quot;alice@example.com&quot;, &quot;85000&quot;},
new String[]{&quot;102&quot;, &quot;Bob&quot;, &quot;bob@example.com&quot;, &quot;92000&quot;}
);
try (FileWriter writer = new FileWriter(filePath)) {
writer.write(&quot;ID,Name,Email,Salary\n&quot;);
for (String[] student : students) {
String encryptedEmail = encrypt(student[2]);
String encryptedSalary = encrypt(student[3]);
writer.write(student[0] + &quot;,&quot; + student[1] + &quot;,&quot; + encryptedEmail +
&quot;,&quot; + encryptedSalary + &quot;\n&quot;);
}
} catch (Exception e) {
System.out.println(e.getMessage());
}
}
public static void readDecryptedCSV(String filePath) {
try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
String line = reader.readLine(); // Header
System.out.println(line);
while ((line = reader.readLine()) != null) {
String[] parts = line.split(&quot;,&quot;);
String id = parts[0];
String name = parts[1];
String email = decrypt(parts[2]);
String salary = decrypt(parts[3]);
System.out.println(id + &quot;,&quot; + name + &quot;,&quot; + email + &quot;,&quot; + salary);
}
} catch (Exception e) {
System.out.println(e.getMessage());
}
}
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print(&quot;Enter CSV file path to save encrypted data: &quot;);

16

String filePath = sc.nextLine();
writeEncryptedCSV(filePath);
System.out.println(&quot;Encrypted CSV written successfully.&quot;);
System.out.println(&quot;\nReading and decrypting the CSV:&quot;);
readDecryptedCSV(filePath);
}
}
