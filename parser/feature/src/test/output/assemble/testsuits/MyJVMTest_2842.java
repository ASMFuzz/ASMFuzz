import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_2842 {

    static int aParam1 = 909;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int old = 0;

    static int ARRLEN = 97;

    static int SCALE = 2;

    int test_ci_scl(AtomicIntegerArray a, int old) {
        for (int i = 0; i * SCALE < ARRLEN; i += 1) {
            a.compareAndSet((i * SCALE), old, -123);
        }
        return old;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2842().test_ci_scl(a, old);
    }
}
