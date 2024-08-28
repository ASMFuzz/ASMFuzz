import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_624 {

    static int aParam1 = 16;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = 2;

    static int k = 2;

    static int old = 6;

    static int ARRLEN = 97;

    int test_vi_inv(AtomicIntegerArray a, int b, int k, int old) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.lazySet((i + k), b);
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_624().test_vi_inv(a, b, k, old);
    }
}
