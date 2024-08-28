import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_13388 {

    static int[] aParam1 = { 476569791, 0, -858579773, 5, 7, 0, 3, 0, 0, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 1, 7, 7, 9, 1530444773, 2014530726, 0, 6, 0, 0 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    AtomicIntegerArray test_cp_unalnsrc(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - UNALIGN_OFF; i += 1) {
            a.set(i, b.get(i + UNALIGN_OFF));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13388().test_cp_unalnsrc(a, b);
    }
}
