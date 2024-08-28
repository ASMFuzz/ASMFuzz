import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_869 {

    static int aParam1 = 690;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int old = 4;

    static int ARRLEN = 97;

    AtomicIntegerArray test_ci_neg(AtomicIntegerArray a, int old) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.lazySet(i, -123);
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_869().test_ci_neg(a, old);
    }
}
