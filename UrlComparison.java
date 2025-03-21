import java.net.URL;

public class UrlComparison {
    public static void main(String[] args) {
        try {
            URL url1 = new URL("https://www.example.com/blog");
            URL url2 = new URL("https://www.example.com/news");

            int result = url1.toString().compareTo(url2.toString());
            
            if (result < 0) {
                System.out.println("url1 is lexicographically smaller than url2");
            } else if (result > 0) {
                System.out.println("url1 is lexicographically larger than url2");
            } else {
                System.out.println("url1 and url2 are lexicographically equal");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}