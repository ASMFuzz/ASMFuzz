import java.net.*;
import java.io.*;

public class MyJVMTest_14442 {

    static boolean isClient = false, isServer = false;

    static String clHost = "K-&W8KZK1?";

    static ServerSocket listener = null;

    static Socket client = null, server = null;

    static int clPort = 816658403;

    static InputStream clis = null, sis = null;

    static OutputStream clos = null, sos = null;

    void run() throws Exception {
        try {
            if (isClient) {
                client = new Socket(clHost, clPort);
                clis = client.getInputStream();
                clos = client.getOutputStream();
                client.setOOBInline(true);
                if (client.getOOBInline() != true) {
                    throw new RuntimeException("Setting OOBINLINE failed");
                }
            }
            if (isServer) {
                server = listener.accept();
                sis = server.getInputStream();
                sos = server.getOutputStream();
            }
            if (isClient) {
                clos.write("Hello".getBytes());
                client.sendUrgentData(100);
                clos.write("world".getBytes());
            }
            String s = "Helloworld";
            if (isServer) {
                for (int y = 0; y < s.length(); y++) {
                    int c = sis.read();
                    if (c != (int) s.charAt(y)) {
                        throw new RuntimeException("Unexpected character read");
                    }
                }
                sos.write("Hello".getBytes());
                server.sendUrgentData(101);
                sos.write("World".getBytes());
            }
            if (isClient) {
                s = "Hello";
                for (int y = 0; y < s.length(); y++) {
                    int c = clis.read();
                    if (c != (int) s.charAt(y)) {
                        throw new RuntimeException("Unexpected character read");
                    }
                }
                if (clis.read() != 101) {
                    throw new RuntimeException("OOB byte not received");
                }
                s = "World";
                for (int y = 0; y < s.length(); y++) {
                    int c = clis.read();
                    if (c != (int) s.charAt(y)) {
                        throw new RuntimeException("Unexpected character read");
                    }
                }
            }
        } finally {
            if (listener != null)
                listener.close();
            if (client != null)
                client.close();
            if (server != null)
                server.close();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14442().run();
    }
}
