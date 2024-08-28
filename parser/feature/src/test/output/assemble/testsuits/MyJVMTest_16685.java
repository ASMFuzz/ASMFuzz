import java.net.*;
import java.nio.channels.*;
import java.util.concurrent.*;
import java.util.*;

public class MyJVMTest_16685 {

    static Runnable r = () -> {
    };

    static SocketAddress sa = null;

    static Channel channel = null;

    Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16685().newThread(r));
    }
}
