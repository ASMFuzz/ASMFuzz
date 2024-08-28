import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_17720 {

    static int[] aParam1 = { -1838388835, 0, 0, 7, 0, 1, 0, 0, 2, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 124;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int k = 1;

    static int ARRLEN = 97;

    int test_cp_inv(AtomicIntegerArray a, AtomicIntegerArray b, int k) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.set((i + k), b.get(i + k));
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17720().test_cp_inv(a, b, k);
    }
}
