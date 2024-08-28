import java.io.*;
import java.net.*;

public class MyJVMTest_780 {

    static boolean shouldTerminate = false;

    static ServerSocket socket = null;

    void terminate() {
        shouldTerminate = true;
        try {
            socket.close();
        } catch (Exception z) {
            z.printStackTrace(System.err);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_780().terminate();
    }
}
