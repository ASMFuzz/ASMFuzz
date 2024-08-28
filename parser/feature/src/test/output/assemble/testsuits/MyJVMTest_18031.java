import java.net.*;
import java.io.*;

public class MyJVMTest_18031 {

    static int code = -1775915765;

    void close() {
        done = true;
        try {
            server.close();
        } catch (IOException unused) {
        }
    }

    static int PROTO_VERS = 5;

    static int DEFAULT_PORT = 1080;

    static int IPV4 = 1;

    static int port = 0;

    static ServerSocket server = null;

    static boolean useV4 = false;

    static boolean done = false;

    static InputStream in = null;

    static OutputStream out = null;

    static Socket client = null;

    static InputStream tin = null;

    static OutputStream tout = null;

    int sendError(int code) {
        try {
            out.write(PROTO_VERS);
            out.write(code);
            out.write(0);
            out.write(IPV4);
            for (int i = 0; i < 6; i++) out.write(0);
            out.flush();
            out.close();
        } catch (IOException ex) {
        }
        return code;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18031().sendError(code);
    }
}
