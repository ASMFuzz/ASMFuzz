import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_2317 {

    static int aParam1 = 94;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = 0;

    static int old = 0;

    static int ARRLEN = 97;

    int test_vi_neg(AtomicIntegerArray a, int b, int old) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.lazySet(i, b);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2317().test_vi_neg(a, b, old);
    }
}
