import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_151 {

    static int[] aParam1 = { -1926873526, 0, 0, 8, 0, 598978189, -32163390, -498102697, 2, 1059697398 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int old = -777925053;

    static int ARRLEN = 97;

    static int SCALE = 2;

    AtomicIntegerArray test_ci_scl(AtomicIntegerArray a, int old) {
        for (int i = 0; i * SCALE < ARRLEN; i += 1) {
            a.set((i * SCALE), -123);
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_151().test_ci_scl(a, old);
    }
}
