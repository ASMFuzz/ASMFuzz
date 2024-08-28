import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_9791 {

    static int[] aParam1 = { 0, 6, 0, -1008969939, 0, -585399932, 4, 4, 1250842878, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = 0;

    static int k = 1260279131;

    static int old = 0;

    static int ARRLEN = 97;

    int test_vi_inv(AtomicIntegerArray a, int b, int k, int old) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.lazySet((i + k), b);
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9791().test_vi_inv(a, b, k, old);
    }
}
