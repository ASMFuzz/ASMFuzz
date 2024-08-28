import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_5563 {

    static int[] aParam1 = { 0, 0, 950545269, 4, 3, 5, 0, 0, 9, 4 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 1237523406, 1814584923, 0, 3, 6, 1606969775, -1895995259, 3, 6, 5 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int OFFSET = 3;

    AtomicIntegerArray test_cp_off(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - OFFSET; i += 1) {
            a.lazySet((i + OFFSET), b.get(i + OFFSET));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5563().test_cp_off(a, b);
    }
}
