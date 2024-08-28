import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_13367 {

    static int aParam1 = 629;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 663982364, 0, 0, 4, 2, 2, -1688016964, 3, 8, 6 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    AtomicIntegerArray test_2ci_neg(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.compareAndSet(i, 123, -123);
            b.compareAndSet(i, 123, -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13367().test_2ci_neg(a, b);
    }
}
