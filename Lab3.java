import java.net.MalformedURLException;
import java.net.URL;
public class Lab3 {
public static void main(String[] args) {
try {
// Create a new URL object
URL url = new URL("https://geet-bice.vercel.app/artist/Coldplay");
// Access URL components
System.out.println("Protocol: " + url.getProtocol()); // e.g., https
System.out.println("Host: " + url.getHost()); // e.g., www.example.com
System.out.println("Path: " + url.getPath()); // e.g., /blog/java-url-example
System.out.println("Port: " + url.getPort()); // e.g., -1 (default port)
System.out.println("Query: " + url.getQuery()); // e.g., null (no query)
System.out.println("Full URL: " + url.toString()); // Full URL
} catch (MalformedURLException e) {
System.out.println("Invalid URL: " + e.getMessage());
}
}
}