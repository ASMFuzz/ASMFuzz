import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_10076 {

    static int[] aParam1 = { 1, 0, 9, 9, 3, 1, 0, 1627198071, 8, 7 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, 9, 6, 0, 0, 5, 4, 4, 0, 1 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 5;

    static int d = 0;

    static int ARRLEN = 97;

    int test_2vi_neg(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.compareAndSet(i, -123, c);
            b.compareAndSet(i, -103, d);
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10076().test_2vi_neg(a, b, c, d);
    }
}
