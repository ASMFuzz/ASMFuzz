import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_8088 {

    static int[] aParam1 = { 0, 3, 0, 0, 0, 1944408462, 5, 0, 0, 1304404596 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = 1;

    static int old = 7;

    static int ARRLEN = 97;

    static int SCALE = 2;

    int test_vi_scl(AtomicIntegerArray a, int b, int old) {
        for (int i = 0; i * SCALE < ARRLEN; i += 1) {
            a.compareAndSet((i * SCALE), old, b);
        }
        return old;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8088().test_vi_scl(a, b, old);
    }
}
