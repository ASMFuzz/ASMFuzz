import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_8147 {

    static int[] aParam1 = { -1128090873, 4, 8, 7, 0, 8, 0, 4, 7, -2069221988 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 1375630160, 3, 3, 7, 1, 9, 0, 1, 0, 2 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int k = 0;

    static int ARRLEN = 97;

    int test_cp_inv(AtomicIntegerArray a, AtomicIntegerArray b, int k) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.set((i + k), b.get(i + k));
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8147().test_cp_inv(a, b, k);
    }
}
