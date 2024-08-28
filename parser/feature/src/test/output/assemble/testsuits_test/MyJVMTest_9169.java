import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_9169 {

    static int[] aParam1 = { 526801905, 5, 6, 2098746753, -1882481810, 1, 0, 6, 0, 1 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 12;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int k = 8;

    static int ARRLEN = 97;

    int test_2ci_inv(AtomicIntegerArray a, AtomicIntegerArray b, int k) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.compareAndSet((i + k), 123, -123);
            b.compareAndSet((i + k), 123, -103);
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9169().test_2ci_inv(a, b, k);
    }
}
