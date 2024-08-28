import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_13745 {

    static int[] aParam1 = { 0, 9, 2116008358, 2, 5, 0, 2, 6, 0, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int k = 5;

    static int old = 31791870;

    static int ARRLEN = 97;

    int test_ci_inv(AtomicIntegerArray a, int k, int old) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.lazySet((i + k), -123);
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13745().test_ci_inv(a, k, old);
    }
}
