import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_12916 {

    static int[] aParam1 = { 8, 0, 3, 0, 0, 0, -365809892, 0, 2, 2 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 445;

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
        new MyJVMTest_12916().test_2ci_unaln(a, b);
    }
}
