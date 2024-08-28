import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_14493 {

    static int aParam1 = 743;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 8, -928947193, 7, 6, 1, 545659610, 8, 1, 5, 0 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int k = 5;

    static int ARRLEN = 97;

    int test_2ci_inv(AtomicIntegerArray a, AtomicIntegerArray b, int k) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.set((i + k), -123);
            b.set((i + k), -103);
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14493().test_2ci_inv(a, b, k);
    }
}
