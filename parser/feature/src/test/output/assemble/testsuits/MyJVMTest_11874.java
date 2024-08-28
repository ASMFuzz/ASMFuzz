import java.io.*;
import java.net.*;

public class MyJVMTest_11874 {

    static ServerSocket serverSocket = null;

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

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11874().doServerSide();
    }
}
