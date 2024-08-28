import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class MyJVMTest_3619 {

    static ServerSocket s = new ServerSocket();

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
        new MyJVMTest_3619().closeSocket(s);
    }
}
