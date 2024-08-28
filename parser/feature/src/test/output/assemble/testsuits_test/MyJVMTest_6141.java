import java.io.*;
import java.net.*;
import java.nio.channels.*;

public class MyJVMTest_6141 {

    static ServerSocket server = null;

    void run() {
        try {
            Socket s = server.accept();
            System.out.println("MyJob-run: client connected: " + s);
            byte[] bs = new byte[10];
            System.out.println("MyJob-run: write some bytes to client.");
            s.getOutputStream().write(bs);
            s.getOutputStream().flush();
            System.out.println("MyJob-run: close the client socket.");
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6141().run();
    }
}
