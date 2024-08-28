import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_5418 {

    static int[] aParam1 = { 0, 2, 3, 5, 8, 0, 7, -2103476044, 8, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 267;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 6;

    static int d = -1414268152;

    static int k = 0;

    static int ARRLEN = 97;

    int test_2vi_inv(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d, int k) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.compareAndSet((i + k), -123, c);
            b.compareAndSet((i + k), -103, d);
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5418().test_2vi_inv(a, b, c, d, k);
    }
}
