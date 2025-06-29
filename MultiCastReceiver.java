import java.net.*;

public class MulticastReceiver {
    public static void main(String[] args) throws Exception {
        MulticastSocket socket = new MulticastSocket(5000);
        InetAddress group = InetAddress.getByName("239.255.0.1");
        socket.joinGroup(group);
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        System.out.println("Waiting for multicast messages...");
        socket.receive(packet);
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Received: " + received);
        socket.leaveGroup(group);
        socket.close();
    }
}
