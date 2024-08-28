import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_17229 {

    static int aParam1 = 678;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int k = 0;

    static int old = 0;

    static int ARRLEN = 97;

    int test_ci_inv(AtomicIntegerArray a, int k, int old) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.compareAndSet((i + k), old, -123);
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17229().test_ci_inv(a, k, old);
    }
}
