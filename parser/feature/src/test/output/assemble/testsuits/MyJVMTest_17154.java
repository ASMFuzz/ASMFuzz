import java.io.*;

public class MyJVMTest_17154 {

    static Class cl = null;

    static long suid = 9223372036854775807L;

    static Object barrier = 8;

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
        new MyJVMTest_17154().run();
    }
}
