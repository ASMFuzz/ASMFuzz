import java.net.*;
import java.security.*;
import javax.net.ssl.*;
import java.io.*;

public class MyJVMTest_592 {

    static byte[] inputStreamParam1 = { 10, 66, -69, -92, 102, 19, -88, -37, 62, 77 };

    static InputStream inputStream = new ByteArrayInputStream(inputStreamParam1);

    static String keystorefile = System.getProperty("test.src", "./") + "/../../../../../javax/net/ssl/etc/keystore";

    static String passphrase = "passphrase";

    static ServerSocket proxySocket = null;

    static Socket sockIn = null;

    static Socket sockOut = null;

    static InputStream input = null;

    static OutputStream output = null;

    static ServerSocket serverSocket = null;

    static SSLSocketFactory sslSocketFactory = null;

    String readLine(InputStream inputStream) throws IOException {
        final StringBuilder line = new StringBuilder();
        int ch;
        while ((ch = inputStream.read()) != -1) {
            if (ch == '\r') {
                continue;
            }
            if (ch == '\n') {
                break;
            }
            line.append((char) ch);
        }
        return line.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_592().readLine(inputStream));
    }
}
