import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_16072 {

    static ServerSocket ss = null;

    static Socket sockIn = null;

    static Socket sockOut = null;

    static InputStream input = null;

    static OutputStream output = null;

    static boolean delayedWrite = false;

    int getPort() {
        return ss.getLocalPort();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16072().getPort());
    }
}
