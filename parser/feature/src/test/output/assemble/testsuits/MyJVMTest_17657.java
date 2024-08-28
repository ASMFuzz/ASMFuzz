import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_17657 {

    static int[] aParam1 = { 3, -361818310, 2, 4, 7, 3, 0, 0, 0, -942623625 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = -622931135;

    static int old = 6;

    static int ARRLEN = 97;

    static int SCALE = 2;

    int test_vi_scl(AtomicIntegerArray a, int b, int old) {
        for (int i = 0; i * SCALE < ARRLEN; i += 1) {
            a.compareAndSet((i * SCALE), old, b);
        }
        return old;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17657().test_vi_scl(a, b, old);
    }
}
