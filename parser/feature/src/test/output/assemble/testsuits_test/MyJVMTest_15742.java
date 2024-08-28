import java.io.*;
import java.net.*;

public class MyJVMTest_15742 {

    void run() {
        try {
            long timeout = (long) (20 * 1000 * ParallelLoad.timeoutFactor);
            Thread.sleep(timeout);
            System.out.println("ParallelLoadWatchdog: Timeout reached: timeout(ms) = " + timeout);
            System.exit(1);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15742().run();
    }
}
