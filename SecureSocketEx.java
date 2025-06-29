import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SecureSocketEx {
    public static void main(String[] a) {
        try {
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket) factory.createSocket("tufohss.edu.np", 443);
            socket.setEnabledCipherSuites(socket.getSupportedCipherSuites());
            Writer out = new OutputStreamWriter(socket.getOutputStream(), "US-ASCII");
            out.write("GET / HTTP/1.1\r\n");
            out.write("Host: tufohss.edu.np\r\n");
            out.write("\r\n");
            out.flush();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String s;
            while (!(s = in.readLine()).equals("")) {
                System.out.println(s);
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
