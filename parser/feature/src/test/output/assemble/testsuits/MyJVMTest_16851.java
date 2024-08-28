import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_16851 {

    static int[] aParam1 = { -1287065264, 0, 0, 0, 2, 3, 0, 0, 4, 4 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 215;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 2026852810;

    static int d = 5;

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
        new MyJVMTest_16851().test_2vi_unaln(a, b, c, d);
    }
}
