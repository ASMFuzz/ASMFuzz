import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_6578 {

    static int aParam1 = 805;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 7, 1168542339, 1, 9, 3, 9, 0, 2, 1090495803, 93128096 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    AtomicIntegerArray test_2ci_aln(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - ALIGN_OFF; i += 1) {
            a.lazySet((i + ALIGN_OFF), -123);
            b.lazySet(i, -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6578().test_2ci_aln(a, b);
    }
}
