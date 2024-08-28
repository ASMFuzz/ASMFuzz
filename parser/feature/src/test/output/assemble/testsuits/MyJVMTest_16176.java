import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_16176 {

    static int[] aParam1 = { 7, 1, 2, 1, -464051240, 0, 2, 7, -388483598, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 116;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    AtomicIntegerArray test_cp_alndst(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - ALIGN_OFF; i += 1) {
            a.lazySet((i + ALIGN_OFF), b.get(i));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16176().test_cp_alndst(a, b);
    }
}
