import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_282 {

    static int aParam1 = 693;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = 8;

    static int old = 6;

    static int ARRLEN = 97;

    int test_vi(AtomicIntegerArray a, int b, int old) {
        for (int i = 0; i < ARRLEN; i += 1) {
            a.compareAndSet(i, old, b);
        }
        return old;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_282().test_vi(a, b, old);
    }
}
