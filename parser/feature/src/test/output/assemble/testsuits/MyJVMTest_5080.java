import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_5080 {

    static int[] aParam1 = { 8, 1, 0, 5, 0, -19284348, 599846880, 9, -1629438590, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, 2, 9, 2, 1, 828803532, 9, 4, 8, 2 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int k = 191331020;

    static int ARRLEN = 97;

    int test_2ci_inv(AtomicIntegerArray a, AtomicIntegerArray b, int k) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.set((i + k), -123);
            b.set((i + k), -103);
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5080().test_2ci_inv(a, b, k);
    }
}
