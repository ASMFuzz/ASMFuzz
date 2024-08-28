import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_11310 {

    static int[] aParam1 = { 0, 1, 9, 3, 0, 8, 3, -2023339847, 730808285, 2 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, 0, 0, 0, 3, 7, 7, -1991475133, 2, 2 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int OFFSET = 3;

    AtomicIntegerArray test_2ci_off(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - OFFSET; i += 1) {
            a.set((i + OFFSET), -123);
            b.set((i + OFFSET), -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11310().test_2ci_off(a, b);
    }
}
