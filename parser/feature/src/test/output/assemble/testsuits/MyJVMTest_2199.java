import java.nio.*;
import java.nio.channels.*;
import java.nio.channels.spi.*;
import java.net.*;

public class MyJVMTest_2199 {

    static Selector selector = null;

    void run() {
        try {
            selector.select();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2199().run();
    }
}
