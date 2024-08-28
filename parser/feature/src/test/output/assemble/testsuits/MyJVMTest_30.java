import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_30 {

    static int[] aParam1 = { 5, 870740568, 0, 0, 1, 5, -1561576674, 4, -1484789491, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 775;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int k = 0;

    static int ARRLEN = 97;

    int test_2ci_inv(AtomicIntegerArray a, AtomicIntegerArray b, int k) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.compareAndSet((i + k), 123, -123);
            b.compareAndSet((i + k), 123, -103);
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_30().test_2ci_inv(a, b, k);
    }
}
