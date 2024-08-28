import java.io.*;

public class MyJVMTest_7608 {

    static Class cl = null;

    static long suid = -9223372036854775808L;

    static Object barrier = -357719197;

    static boolean ok = true;

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
        new MyJVMTest_7608().run();
    }
}
