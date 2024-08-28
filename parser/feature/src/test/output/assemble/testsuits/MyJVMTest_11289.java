import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_11289 {

    static int[] aParam1 = { 0, -782278534, 0, 0, -2070885917, 5, 2, 8, 0, 2 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 9, 6, 0, 2038622917, 2, 0, -397323942, 0, 9, 0 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int OFFSET = 3;

    AtomicIntegerArray test_2ci_off(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - OFFSET; i += 1) {
            a.lazySet((i + OFFSET), -123);
            b.lazySet((i + OFFSET), -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11289().test_2ci_off(a, b);
    }
}
