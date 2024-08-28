import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_12138 {

    static int[] aParam1 = { 1311944374, 6, 4, 0, 0, 0, 4, 0, 1067606784, -288323797 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int old = 3;

    static int ARRLEN = 97;

    static int SCALE = 2;

    int test_ci_scl(AtomicIntegerArray a, int old) {
        for (int i = 0; i * SCALE < ARRLEN; i += 1) {
            a.compareAndSet((i * SCALE), old, -123);
        }
        return old;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12138().test_ci_scl(a, old);
    }
}
