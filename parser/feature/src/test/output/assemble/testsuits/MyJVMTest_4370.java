import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_4370 {

    static int[] aParam1 = { 20975916, 0, 53482972, -1045210491, 2106586441, 0, -1362406792, 0, 0, 2 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int k = 0;

    static int old = 5;

    static int ARRLEN = 97;

    int test_ci_inv(AtomicIntegerArray a, int k, int old) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.lazySet((i + k), -123);
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4370().test_ci_inv(a, k, old);
    }
}
