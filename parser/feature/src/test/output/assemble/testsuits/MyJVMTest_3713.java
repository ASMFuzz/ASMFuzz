import java.io.*;
import java.nio.*;
import java.net.*;
import java.nio.channels.*;

public class MyJVMTest_3713 {

    static boolean wakeupDone = false;

    static Selector sel = null;

    static long delay = 9223372036854775807L;

    void run() {
        try {
            Thread.sleep(delay);
            wakeupDone = true;
            sel.wakeup();
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3713().run();
    }
}
