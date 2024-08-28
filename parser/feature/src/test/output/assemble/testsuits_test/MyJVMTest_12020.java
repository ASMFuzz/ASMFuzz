import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_12020 {

    static int aParam1 = 119;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 8, 1364590187, -1562998660, 5, 6, 0, 2, -5494049, 0, 0 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    AtomicIntegerArray test_cp_neg(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.set(i, b.get(i));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12020().test_cp_neg(a, b);
    }
}
