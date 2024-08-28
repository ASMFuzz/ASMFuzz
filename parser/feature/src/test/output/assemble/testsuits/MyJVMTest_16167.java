import java.net.*;
import java.security.*;
import javax.net.ssl.*;
import java.io.*;

public class MyJVMTest_16167 {

    static byte[] inputStreamParam1 = { 76, -38, 99, -57, 63, 12, -103, 113, -73, -94 };

    static InputStream inputStream = new ByteArrayInputStream(inputStreamParam1);

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

    static String keystorefile = System.getProperty("test.src", "./") + "/../../../../../javax/net/ssl/etc/keystore";

    static String passphrase = "passphrase";

    static ServerSocket proxySocket = null;

    static Socket sockIn = null;

    static Socket sockOut = null;

    static InputStream input = null;

    static OutputStream output = null;

    static ServerSocket serverSocket = null;

    static SSLSocketFactory sslSocketFactory = null;

    String readHeader(InputStream inputStream) throws IOException {
        String line;
        String firstLine = null;
        while ((line = readLine(inputStream)) != null && line.length() > 0) {
            if (firstLine == null) {
                firstLine = line;
            }
        }
        return firstLine;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16167().readHeader(inputStream));
    }
}
