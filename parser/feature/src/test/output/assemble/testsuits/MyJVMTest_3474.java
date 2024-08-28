import java.net.*;

public class MyJVMTest_3474 {

    static Socket s = null;

    static int timeout = 0;

    void run() {
        try {
            Thread.currentThread().sleep(timeout);
            s.close();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3474().run();
    }
}
