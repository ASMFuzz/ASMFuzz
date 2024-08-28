import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_10048 {

    static int[] aParam1 = { 233563647, -890751631, 0, -571688783, 3, 1, 0, -499075804, 2, 7 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int old = 5;

    static int ARRLEN = 97;

    AtomicIntegerArray test_ci_neg(AtomicIntegerArray a, int old) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.lazySet(i, -123);
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10048().test_ci_neg(a, old);
    }
}
