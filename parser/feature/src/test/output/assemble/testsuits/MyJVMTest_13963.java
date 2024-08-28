import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_13963 {

    static int aParam1 = 183;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, 3, 6, 4, 3, 68789585, 600918764, 3, 8, 0 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    AtomicIntegerArray test_2ci_unaln(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - UNALIGN_OFF; i += 1) {
            a.lazySet((i + UNALIGN_OFF), -123);
            b.lazySet(i, -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13963().test_2ci_unaln(a, b);
    }
}
