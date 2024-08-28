import java.nio.channels.*;
import java.net.*;
import java.nio.ByteBuffer;

public class MyJVMTest_15027 {

    static Runnable r = () -> {
    };

    static int K = 1024;

    static AsynchronousSocketChannel client = null;

    static SocketChannel peer = null;

    static ByteBuffer dst = null;

    Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15027().newThread(r));
    }
}
