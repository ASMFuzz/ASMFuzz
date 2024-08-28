import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_7677 {

    static int[] aParam1 = { 0, 8, 0, -1724306617, -1069130308, 9, 7, 0, 0, 2 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int k = 648690304;

    static int old = 8;

    static int ARRLEN = 97;

    int test_ci_inv(AtomicIntegerArray a, int k, int old) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.compareAndSet((i + k), old, -123);
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7677().test_ci_inv(a, k, old);
    }
}
