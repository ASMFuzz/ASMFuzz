import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_2326 {

    static int[] aParam1 = { 5, 8, 0, 694432667, 9, 1, 0, 4, 5, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, -1700095243, 1, 5, 0, 9, -702892699, -52153763, 0, -764652142 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    AtomicIntegerArray test_cp_neg(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.compareAndSet(i, -123, b.get(i));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2326().test_cp_neg(a, b);
    }
}
