import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_17207 {

    static int aParam1 = 565;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 613;

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
        new MyJVMTest_17207().test_2ci_neg(a, b);
    }
}
