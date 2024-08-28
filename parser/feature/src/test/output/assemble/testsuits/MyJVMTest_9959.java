import java.io.*;
import java.net.*;

public class MyJVMTest_9959 {

    static boolean shouldTerminate = true;

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
        new MyJVMTest_9959().terminate();
    }
}
