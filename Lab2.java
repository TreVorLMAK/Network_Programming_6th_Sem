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

                // multicast ho ki vanera check gareko
                if (address.isMulticastAddress()) {
                    System.out.println("This is a Multicast Address.");
                }
                // yedi broadcast po ho ki?
                else if ("255.255.255.255".equals(address.getHostAddress())) {
                    System.out.println("This is a Broadcast Address.");
                }
                // tyo duitai navaye ta unicast ho pakka
                else {
                    System.out.println("This is a Unicast Address.");
                }
                System.out.println();  
            }

        } catch (UnknownHostException e) {
            System.out.println("Invalid IP address: " + e.getMessage());
        }
    }
}
