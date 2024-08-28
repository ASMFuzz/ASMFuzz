import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_17105 {

    static ServerSocket ss = null;

    static Socket clientSocket = null;

    static Socket sockIn = null;

    static Socket sockOut = null;

    static InputStream input = null;

    static OutputStream output = null;

    static boolean delayedWrite = false;

    void respondForConnect() throws Exception {
        OutputStream out = clientSocket.getOutputStream();
        PrintWriter pout = new PrintWriter(out);
        pout.println("HTTP/1.1 200 OK");
        pout.println();
        pout.flush();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17105().respondForConnect();
    }
}
