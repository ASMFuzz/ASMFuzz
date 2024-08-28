import java.io.*;
import java.nio.*;
import java.net.*;
import java.nio.channels.*;

public class MyJVMTest_13050 {

    static boolean wakeupDone = false;

    static Selector sel = null;

    static long delay = 3687583316393313296L;

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
        new MyJVMTest_13050().run();
    }
}
