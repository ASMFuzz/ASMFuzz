import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_3256 {

    static int aParam1 = 757;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int old = 1;

    static int ARRLEN = 97;

    int test_ci_neg(AtomicIntegerArray a, int old) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.compareAndSet(i, old, -123);
        }
        return old;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3256().test_ci_neg(a, old);
    }
}
