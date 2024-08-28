import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_12932 {

    static int[] aParam1 = { 1, 0, 0, 6, 0, -2049248912, 0, 1350116886, 1, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 574;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 7;

    static int d = 0;

    static int ARRLEN = 97;

    int test_2vi_neg(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.lazySet(i, c);
            b.lazySet(i, d);
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12932().test_2vi_neg(a, b, c, d);
    }
}
