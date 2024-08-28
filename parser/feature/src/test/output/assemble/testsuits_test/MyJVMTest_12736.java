import java.io.*;

public class MyJVMTest_12736 {

    static Class<?> cl = null;

    static long suid = 0;

    static Object barrier = 3;

    static boolean ok = false;

    void run() {
        synchronized (barrier) {
            try {
                barrier.wait();
            } catch (InterruptedException ex) {
            }
        }
        for (int i = 0; i < 100; i++) {
            if (ObjectStreamClass.lookup(cl).getSerialVersionUID() != suid) {
                return;
            }
        }
        ok = true;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12736().run();
    }
}
