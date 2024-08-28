import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_7658 {

    static int[] aParam1 = { 6, 5, 1, 6, 3, 1615298636, 0, 7, -1391758685, 3 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 958;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    AtomicIntegerArray test_2ci_neg(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.lazySet(i, -123);
            b.lazySet(i, -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7658().test_2ci_neg(a, b);
    }
}
