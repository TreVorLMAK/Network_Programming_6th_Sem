import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocketFactory;

public class ServerSocketEx {
    public static void main(String[] a) {
        try {
            ServerSocket serverSocket = ((SSLServerSocketFactory)
                SSLServerSocketFactory.getDefault()).createServerSocket(1422);
            Socket s = serverSocket.accept();
            System.out.println(s + " Client Accepted and Connected...");
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
