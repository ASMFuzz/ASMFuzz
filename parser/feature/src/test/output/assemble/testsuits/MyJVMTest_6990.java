import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_6990 {

    static int aParam1 = 10;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 1914555084, 6, 9, 5, 0, 0, 0, 5, 1, 210076050 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int k = 1;

    static int ARRLEN = 97;

    int test_cp_inv(AtomicIntegerArray a, AtomicIntegerArray b, int k) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.compareAndSet((i + k), -123, b.get(i + k));
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6990().test_cp_inv(a, b, k);
    }
}
