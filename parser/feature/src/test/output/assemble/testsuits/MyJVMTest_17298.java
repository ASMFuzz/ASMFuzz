import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_17298 {

    static int[] aParam1 = { 0, 4, 0, 0, 813992298, 118311046, 576679535, 5, 4, 4 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = 0;

    static int k = 4;

    static int old = -1266777565;

    static int ARRLEN = 97;

    int test_vi_inv(AtomicIntegerArray a, int b, int k, int old) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.set((i + k), b);
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17298().test_vi_inv(a, b, k, old);
    }
}
