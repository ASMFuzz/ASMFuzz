import java.io.*;
import java.net.*;

public class MyJVMTest_14892 {

    void doServerSide() throws Exception {
        try {
            Socket socket = serverSocket.accept();
            OutputStream os = socket.getOutputStream();
            os.write(85);
            os.flush();
            socket.close();
        } finally {
            serverSocket.close();
        }
    }

    static ServerSocket serverSocket = null;

    void run() {
        try {
            doServerSide();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14892().run();
    }
}
