import java.net.*;

public class MyJVMTest_1518 {

    static InetAddress addr = null;

    static int port = 1404978170;

    void run() {
        try {
            Socket s = new Socket(addr, port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1518().run();
    }
}
