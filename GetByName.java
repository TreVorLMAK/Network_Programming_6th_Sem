import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetByName{
    public static void main(String[] args) {
     try {
         InetAddress address = InetAddress.getByName("Www.facebook.com");
         System.out.println("Hostname = " + address.getHostName());
         System.out.println("\nIP Address = " + address.getHostAddress());
     } catch (UnknownHostException e) {
        System.out.println("Error");
     }
}
}