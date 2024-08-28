import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_14844 {

    static int[] aParam1 = { 0, -116170638, 0, 5, 9, 0, 8, 0, 1294060882, 146202392 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, 6, 8, 9, 0, 0, 7, 8, 1, 0 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 6;

    static int d = 1243466581;

    static int k = 8;

    static int ARRLEN = 97;

    int test_2vi_inv(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d, int k) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.compareAndSet((i + k), -123, c);
            b.compareAndSet((i + k), -103, d);
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14844().test_2vi_inv(a, b, c, d, k);
    }
}
