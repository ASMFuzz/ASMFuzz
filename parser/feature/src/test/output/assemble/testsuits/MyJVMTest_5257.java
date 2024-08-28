import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_5257 {

    static int aParam1 = 489;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 9, 397801452, 5, 5, 0, 7, 6, 0, 0, 0 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    AtomicIntegerArray test_2ci_aln(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - ALIGN_OFF; i += 1) {
            a.set((i + ALIGN_OFF), -123);
            b.set(i, -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5257().test_2ci_aln(a, b);
    }
}
