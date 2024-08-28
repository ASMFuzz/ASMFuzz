import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_3581 {

    static int[] aParam1 = { 1408703861, -280810323, 0, 423204152, 4, 0, 0, 4, 4, 611752965 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 8;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    AtomicIntegerArray test_2ci_unaln(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - UNALIGN_OFF; i += 1) {
            a.set((i + UNALIGN_OFF), -123);
            b.set(i, -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3581().test_2ci_unaln(a, b);
    }
}
