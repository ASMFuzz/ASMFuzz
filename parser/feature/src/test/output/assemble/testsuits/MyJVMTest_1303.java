import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_1303 {

    static int[] aParam1 = { -952140526, -161848535, 0, 1, 0, 5, 4, -1487945759, 3, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, 3, 4, 0, 9, 0, 0, 0, 0, 1512922561 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 3;

    static int d = 0;

    static int ARRLEN = 97;

    int test_2vi(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        for (int i = 0; i < ARRLEN; i += 1) {
            a.compareAndSet(i, -123, c);
            b.compareAndSet(i, -103, d);
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1303().test_2vi(a, b, c, d);
    }
}
