import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;

public class CookieStoreExample {
    public static void main(String[] args) {
        CookieManager cookieManager = new CookieManager();
        CookieStore cookieStore = cookieManager.getCookieStore();

        URI uri = URI.create("https://example.com");
        HttpCookie cookie = new HttpCookie("sessionID", "12345");
        cookieStore.add(uri, cookie);

        System.out.println("Cookies: " + cookieStore.getCookies());
    }
}
