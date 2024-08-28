import java.net.*;
import java.io.*;

public class MyJVMTest_18000 {

    void testClose() throws IOException {
        boolean error = true;
        InetAddress addr = InetAddress.getLocalHost();
        ServerSocket ss = new ServerSocket(0);
        int port = ss.getLocalPort();
        Thread t = new Thread(new Thread("Close-Available-1") {

            public void run() {
                try {
                    Socket s = new Socket(addr, port);
                    s.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        Socket soc = ss.accept();
        ss.close();
        DataInputStream is = new DataInputStream(soc.getInputStream());
        is.close();
        try {
            is.available();
        } catch (IOException ex) {
            error = false;
        }
        if (error)
            throw new RuntimeException("Available() can be called after stream closed.");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18000().run();
    }
}
