import java.net.*;
import java.security.*;
import javax.net.ssl.*;
import java.io.*;

public class MyJVMTest_9758 {

    static byte[] inputStreamParam1 = { 109, -64, -26, -89, -98, -100, -37, 92, 93, 105 };

    static int inputStreamParam2 = 996;

    static int inputStreamParam3 = 803;

    static InputStream inputStream = new ByteArrayInputStream(inputStreamParam1, inputStreamParam2, inputStreamParam3);

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
        System.out.println(new MyJVMTest_9758().readLine(inputStream));
    }
}
