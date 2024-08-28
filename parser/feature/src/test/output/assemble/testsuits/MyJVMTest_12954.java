import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_12954 {

    static int sParam1 = 613;

    static ServerSocket s = new ServerSocket(sParam1);

    static Exception serverException = null;

    static Exception clientException = null;

    static Thread clientThread = null;

    static Thread serverThread = null;

    ServerSocket closeSocket(ServerSocket s) {
        try {
            if (s != null) {
                s.close();
            }
        } catch (Exception e) {
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12954().closeSocket(s);
    }
}
