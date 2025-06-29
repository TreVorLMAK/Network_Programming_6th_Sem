import java.io.*;
import java.net.*;
import java.util.*;

public class HeaderExample {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://google.com");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        String contentType = conn.getHeaderField("Content-Type");
        String server = conn.getHeaderField("Server");
        System.out.println("Content-Type: " + contentType);
        System.out.println("Server: " + server);

        Map<String, List<String>> headers = conn.getHeaderFields();
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            for (String value : entry.getValue()) {
                System.out.println(entry.getKey() + ": " + value);
            }
        }

        conn.disconnect();
    }
}
