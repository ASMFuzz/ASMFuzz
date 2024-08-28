import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_1719 {

    static int aParam1 = 43;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int old = 7;

    static int ARRLEN = 97;

    static int OFFSET = 3;

    int test_ci_off(AtomicIntegerArray a, int old) {
        for (int i = 0; i < ARRLEN - OFFSET; i += 1) {
            a.compareAndSet((i + OFFSET), old, -123);
        }
        return old;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1719().test_ci_off(a, old);
    }
}
