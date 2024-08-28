import java.net.*;
import java.io.*;

public class MyJVMTest_1722 {

    static ServerSocket server = null;

    static String resp = "HTTP/1.1 200 Ok\r\nContent-length: 0\r\n\r\n";

    void run() {
        try {
            Socket s = server.accept();
            OutputStream os = s.getOutputStream();
            os.write(resp.getBytes());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1722().run();
    }
}
