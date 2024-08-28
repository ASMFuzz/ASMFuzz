import java.util.*;
import java.nio.*;
import java.nio.charset.*;
import java.util.concurrent.*;

public class MyJVMTest_1287 {

    static String name = "o#>bq%O]jJ";

    void collectAllGarbage() {
        final java.util.concurrent.CountDownLatch drained = new java.util.concurrent.CountDownLatch(1);
        try {
            System.gc();
            new Object() {

                protected void finalize() {
                    drained.countDown();
                }
            };
            System.gc();
            drained.await();
            System.gc();
        } catch (InterruptedException e) {
            throw new Error(e);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1287().finalize();
    }
}
