import java.net.InetAddress;
import java.net.UnknownHostException;

public class Lab1 {
    public static void main(String[] args) {
        try {
            // 1. Get and display the local host's IP address
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local Host Name: " + localHost.getHostName());
            System.out.println("Local Host IP Address: " + localHost.getHostAddress());

            // 2. Get and display the IP address of a given hostname
            String host = "www.google.com"; 
            InetAddress remoteHost = InetAddress.getByName(host);
            System.out.println("\nHost Name: " + remoteHost.getHostName());
            System.out.println("IP Address: " + remoteHost.getHostAddress());

            // 3. Get and display all IP addresses associated with a hostname
            InetAddress[] allAddresses = InetAddress.getAllByName(host);
            System.out.println("\nAll IP Addresses for " + host + ":");
            for (InetAddress address : allAddresses) {
                System.out.println(address.getHostAddress());
            }
        } catch (UnknownHostException e) {
            System.out.println("Host not found: " + e.getMessage());
        }
    }
}
