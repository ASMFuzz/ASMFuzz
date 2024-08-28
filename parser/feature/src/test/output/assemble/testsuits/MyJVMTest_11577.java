import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_11577 {

    static int[] aParam1 = { -203381457, 0, 3, 0, -1504786446, 8, 6, 0, 0, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = -485995986;

    static int old = 5;

    static int ARRLEN = 97;

    int test_vi_neg(AtomicIntegerArray a, int b, int old) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.lazySet(i, b);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11577().test_vi_neg(a, b, old);
    }
}
