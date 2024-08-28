import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_2092 {

    static int[] aParam1 = { 9, 0, 0, 0, 0, 244738438, 0, 0, 592845519, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 418;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    AtomicIntegerArray test_cp_unalndst(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - UNALIGN_OFF; i += 1) {
            a.lazySet((i + UNALIGN_OFF), b.get(i));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2092().test_cp_unalndst(a, b);
    }
}
