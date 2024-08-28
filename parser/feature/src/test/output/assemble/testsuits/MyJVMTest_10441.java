import java.io.*;

public class MyJVMTest_10441 {

    static Class<?> cl = null;

    static Object barrier = 680662622;

    static boolean ok = true;

    void run() {
        synchronized (barrier) {
            try {
                barrier.wait();
            } catch (InterruptedException ex) {
            }
        }
        for (int i = 0; i < 100; i++) {
            try {
                ObjectStreamClass.lookup(cl);
                return;
            } catch (Throwable th) {
            }
        }
        ok = true;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10441().run();
    }
}
