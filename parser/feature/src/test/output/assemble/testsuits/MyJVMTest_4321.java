import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_4321 {

    static int aParam1 = 59;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 532256706, 8, 0, 0, 1, 158336809, 2, -890270017, 6, 0 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    AtomicIntegerArray test_2ci_neg(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.set(i, -123);
            b.set(i, -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4321().test_2ci_neg(a, b);
    }
}
