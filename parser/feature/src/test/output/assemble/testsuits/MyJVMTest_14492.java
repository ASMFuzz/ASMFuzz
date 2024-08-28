import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_14492 {

    static int[] aParam1 = { 4, 806883568, 7, 0, -93349561, 7, 3, -693988532, 7, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int old = 8;

    static int ARRLEN = 97;

    static int OFFSET = 3;

    AtomicIntegerArray test_ci_off(AtomicIntegerArray a, int old) {
        for (int i = 0; i < ARRLEN - OFFSET; i += 1) {
            a.set((i + OFFSET), -123);
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14492().test_ci_off(a, old);
    }
}
