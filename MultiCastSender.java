import java.net.*;

public class MulticastSender {
    public static void main(String[] args) throws Exception {
        MulticastSocket socket = new MulticastSocket();
        InetAddress group = InetAddress.getByName("239.255.0.1");
        String message = "Hello Multicast Group!";
        byte[] buffer = message.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, 5000);
        socket.send(packet);
        socket.close();
    }
}
