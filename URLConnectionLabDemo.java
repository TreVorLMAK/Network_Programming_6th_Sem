import java.io.*;
import java.net.*;
import java.util.*;

public class URLConnectionLabDemo {

    public static void main(String[] args) {
        System.out.println("1. --- Basic GET Request ---");
        basicGetRequest();

        System.out.println("\n2. --- Reading Specific Headers ---");
        readSpecificHeaders();

        System.out.println("\n3. --- Reading All Headers ---");
        readAllHeaders();

        System.out.println("\n4. --- POST Request Example ---");
        postRequest();

        System.out.println("\n5. --- Proxy Example (Optional: Requires Real Proxy) ---");
        proxyExample(); // This will fail unless a working proxy is configured
    }

    static void basicGetRequest() {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine).append("\n");
            }
            in.close();
            conn.disconnect();

            System.out.println("Response:\n" + content);

        } catch (Exception e) {
            System.err.println("Error in basicGetRequest: " + e.getMessage());
        }
    }

    static void readSpecificHeaders() {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            String contentType = conn.getHeaderField("Content-Type");
            String server = conn.getHeaderField("Server");

            System.out.println("Content-Type: " + contentType);
            System.out.println("Server: " + server);

            conn.disconnect();
        } catch (Exception e) {
            System.err.println("Error in readSpecificHeaders: " + e.getMessage());
        }
    }

    static void readAllHeaders() {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            Map<String, List<String>> headers = conn.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            conn.disconnect();
        } catch (Exception e) {
            System.err.println("Error in readAllHeaders: " + e.getMessage());
        }
    }

    static void postRequest() {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");

            String jsonInput = "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}";

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInput.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int code = conn.getResponseCode();
            System.out.println("POST Response Code: " + code);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String responseLine;

            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }

            System.out.println("Response:\n" + response.toString());

        } catch (Exception e) {
            System.err.println("Error in postRequest: " + e.getMessage());
        }
    }

    static void proxyExample() {
        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 8080)); // dummy proxy
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(proxy);
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine).append("\n");
            }
            in.close();
            conn.disconnect();

            System.out.println("Response via Proxy:\n" + content);

        } catch (Exception e) {
            System.err.println("Proxy request failed (expected unless proxy is set): " + e.getMessage());
        }
    }
}
