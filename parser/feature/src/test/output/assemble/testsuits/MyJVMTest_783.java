import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_783 {

    static int[] aParam1 = { 9, 0, -513498540, 803341976, 9, 1, 3, 0, 1, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = -110143178;

    static int old = 1263558036;

    static int ARRLEN = 97;

    int test_vi_neg(AtomicIntegerArray a, int b, int old) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.compareAndSet(i, old, b);
        }
        return old;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_783().test_vi_neg(a, b, old);
    }
}
