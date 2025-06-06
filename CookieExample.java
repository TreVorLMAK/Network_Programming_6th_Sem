import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.URL;

public class CookieExample {
    public static void main(String[] args) throws Exception {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(cookieManager);

        URL url = new URL("https://www.facebook.com/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);
        System.out.println("Cookies: " + cookieManager.getCookieStore().getCookies());
    }
}
