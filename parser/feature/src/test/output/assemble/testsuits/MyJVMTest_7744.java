import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_7744 {

    static int[] aParam1 = { 3, 1308501243, -674786334, 844072541, 2, -185164396, 0, 0, 3, 766483931 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = 0;

    static int k = 5;

    static int old = 181782275;

    static int ARRLEN = 97;

    int test_vi_inv(AtomicIntegerArray a, int b, int k, int old) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.set((i + k), b);
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7744().test_vi_inv(a, b, k, old);
    }
}
