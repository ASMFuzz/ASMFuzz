import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_9299 {

    static int aParam1 = 55;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int old = 7;

    static int ARRLEN = 97;

    static int SCALE = 2;

    AtomicIntegerArray test_ci_scl(AtomicIntegerArray a, int old) {
        for (int i = 0; i * SCALE < ARRLEN; i += 1) {
            a.set((i * SCALE), -123);
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9299().test_ci_scl(a, old);
    }
}
