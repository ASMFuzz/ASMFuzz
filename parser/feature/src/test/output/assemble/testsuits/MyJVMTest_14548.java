import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_14548 {

    static int[] aParam1 = { 0, 7, 637710549, 0, 0, 7, 0, 451187036, 5, 5 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = 821394389;

    static int k = 3;

    static int old = 0;

    static int ARRLEN = 97;

    int test_vi_inv(AtomicIntegerArray a, int b, int k, int old) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.compareAndSet((i + k), old, b);
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14548().test_vi_inv(a, b, k, old);
    }
}
