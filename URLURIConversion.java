import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class URLURIConversion {
    public static void main(String[] args) {
        try {
            System.out.println("===== URL and URI Conversion Examples =====");
            
            // Sample URL and URI for demonstration
            String urlString = "https://www.youtube.com/watch?v=sS8ELauHmGM";
            
            // 1. String to URL conversion
            System.out.println("\n1. String to URL Conversion:");
            URL url = stringToURL(urlString);
            System.out.println("Original String: " + urlString);
            System.out.println("Converted URL: " + url);
            
            // 2. URL to String conversion
            System.out.println("\n2. URL to String Conversion:");
            String convertedUrlString = urlToString(url);
            System.out.println("Original URL: " + url);
            System.out.println("Converted String: " + convertedUrlString);
            
            // 3. URL to URI conversion
            System.out.println("\n3. URL to URI Conversion:");
            URI uri = urlToURI(url);
            System.out.println("Original URL: " + url);
            System.out.println("Converted URI: " + uri);
            
            // 4. URI to URL conversion
            System.out.println("\n4. URI to URL Conversion:");
            URL urlFromUri = uriToURL(uri);
            System.out.println("Original URI: " + uri);
            System.out.println("Converted URL: " + urlFromUri);
            
            // 5. String to URI direct conversion
            System.out.println("\n5. String to URI Direct Conversion:");
            URI uriFromString = new URI(urlString);
            System.out.println("Original String: " + urlString);
            System.out.println("Converted URI: " + uriFromString);
            
            // 6. URI to String conversion
            System.out.println("\n6. URI to String Conversion:");
            String stringFromUri = uri.toString();
            System.out.println("Original URI: " + uri);
            System.out.println("Converted String: " + stringFromUri);
            
        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // 1. Convert String to URL
    public static URL stringToURL(String urlString) throws MalformedURLException {
        URL url = new URL(urlString);
        return url;
    }
    
    // 2. Convert URL to String
    public static String urlToString(URL url) {
        return url.toString();
    }
    
    // 3. Convert URL to URI
    public static URI urlToURI(URL url) throws URISyntaxException {
        URI uri = url.toURI();
        return uri;
    }
    
    // 4. Convert URI to URL
    public static URL uriToURL(URI uri) throws MalformedURLException {
        URL url = uri.toURL();
        return url;
    }
}