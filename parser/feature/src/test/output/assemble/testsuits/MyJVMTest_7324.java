import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_7324 {

    static int[] aParam1 = { 7, 1, 0, 0, 0, 0, 6, 357677464, 0, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 632;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 0;

    static int d = 4;

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int test_2vi_unaln(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        for (int i = 0; i < ARRLEN - UNALIGN_OFF; i += 1) {
            a.set(i, c);
            b.set((i + UNALIGN_OFF), d);
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7324().test_2vi_unaln(a, b, c, d);
    }
}
