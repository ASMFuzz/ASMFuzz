import java.nio.*;
import java.nio.channels.*;
import java.nio.channels.spi.*;
import java.net.*;

public class MyJVMTest_11452 {

    static Selector selector = null;

    void run() {
        try {
            selector.select();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11452().run();
    }
}
