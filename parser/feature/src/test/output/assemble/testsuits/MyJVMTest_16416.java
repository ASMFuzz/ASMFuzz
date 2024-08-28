import java.io.*;
import java.net.*;

public class MyJVMTest_16416 {

    static boolean shouldTerminate = false;

    static ServerSocket socket = null;

    void run() {
        try {
            socket = new ServerSocket(1122);
            Socket client = socket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            shouldTerminate = false;
            while (!shouldTerminate) {
                String msg = reader.readLine();
            }
        } catch (Exception z) {
            if (!shouldTerminate) {
                z.printStackTrace(System.err);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16416().run();
    }
}
