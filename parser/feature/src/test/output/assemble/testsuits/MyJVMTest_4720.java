import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_4720 {

    static int[] aParam1 = { 7, 1834389815, -1689665145, 0, 0, 6, -1430906026, 0, 6, 5 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 509;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    AtomicIntegerArray test_cp_unalndst(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - UNALIGN_OFF; i += 1) {
            a.set((i + UNALIGN_OFF), b.get(i));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4720().test_cp_unalndst(a, b);
    }
}
