import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_17810 {

    static int[] aParam1 = { 202108003, -1476936130, 3, 2061709707, 0, 1, -32557814, 2, 6, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 9, 0, 0, 6, 4, 1921017073, 522897879, -1883302981, 2, 5 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 6;

    static int d = 7;

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    int test_2vi_aln(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        for (int i = 0; i < ARRLEN - ALIGN_OFF; i += 1) {
            a.lazySet(i, c);
            b.lazySet((i + ALIGN_OFF), d);
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17810().test_2vi_aln(a, b, c, d);
    }
}
