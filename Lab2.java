import java.net.InetAddress;
import java.net.UnknownHostException;

public class Lab2 {

    public static void main(String[] args) {
        try {
            // Test IP addresses
            String[] testIPs = {"192.168.1.10", "255.255.255.255", "224.0.0.1"};

            for (String ip : testIPs) {
                InetAddress address = InetAddress.getByName(ip);
                System.out.println("IP Address: " + address.getHostAddress());

                // Check if the address is multicast
                if (address.isMulticastAddress()) {
                    System.out.println("This is a Multicast Address.");
                }
                // Check if the address is broadcast
                else if ("255.255.255.255".equals(address.getHostAddress())) {
                    System.out.println("This is a Broadcast Address.");
                }
                // Otherwise, it's a unicast address
                else {
                    System.out.println("This is a Unicast Address.");
                }
                System.out.println();  // Add space between results
            }

        } catch (UnknownHostException e) {
            System.out.println("Invalid IP address: " + e.getMessage());
        }
    }
}
