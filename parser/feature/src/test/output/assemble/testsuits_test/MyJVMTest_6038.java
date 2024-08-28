import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_6038 {

    static int[] aParam1 = { 4, -639245035, 256008315, 7, -1873216331, 4, 2, 2025722991, 0, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 6, 0, 2, 7, 7, 0, -156917421, -1081565805, 5, 0 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int SCALE = 2;

    AtomicIntegerArray test_2ci_scl(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i * SCALE < ARRLEN; i += 1) {
            a.compareAndSet((i * SCALE), 123, -123);
            b.compareAndSet((i * SCALE), 123, -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6038().test_2ci_scl(a, b);
    }
}
