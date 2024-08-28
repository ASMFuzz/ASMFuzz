import java.io.*;
import java.net.*;

public class MyJVMTest_2594 {

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
        new MyJVMTest_2594().doServerSide();
    }
}
