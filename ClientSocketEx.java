import java.net.Socket;
import javax.net.ssl.SSLSocketFactory;

public class ClientSocketEx {
    public static void main(String[] a) {
        try {
            Socket socket = ((SSLSocketFactory) SSLSocketFactory.getDefault())
                            .createSocket("localhost", 1422);
            System.out.println("Server Connected: " + socket);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
