import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_10507 {

    static int[] aParam1 = { -855974144, 0, 1, 573778184, 1919251214, -1549089982, 2, 0, 9, 1857246977 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 592;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 6;

    static int d = 9;

    static int ARRLEN = 97;

    int test_2vi(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        for (int i = 0; i < ARRLEN; i += 1) {
            a.compareAndSet(i, -123, c);
            b.compareAndSet(i, -103, d);
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10507().test_2vi(a, b, c, d);
    }
}
