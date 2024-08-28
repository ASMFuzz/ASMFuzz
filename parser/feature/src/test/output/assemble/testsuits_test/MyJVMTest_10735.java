import java.net.*;

public class MyJVMTest_10735 {

    static InetAddress addr = null;

    static int port = 0;

    void run() {
        try {
            Socket s = new Socket(addr, port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10735().run();
    }
}
