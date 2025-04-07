import java.net.URL;
public class UrlConversion {
public static void main(String[] args) {
try {
URL url = new URL("https://www.example.com/blog");
String urlString = url.toString();
System.out.println("URL as String: " + urlString);
System.err.println("URL as String (Error Stream): " + urlString);
} catch (Exception e) {
System.out.println("Error: " + e.getMessage());
}
}
}
