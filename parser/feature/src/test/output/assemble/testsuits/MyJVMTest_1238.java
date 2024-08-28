import java.io.*;

public class MyJVMTest_1238 {

    static Class cl = null;

    static Object barrier = 5;

    static boolean ok = false;

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
        new MyJVMTest_1238().run();
    }
}
