import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_8235 {

    static int aParam1 = 323;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, -1558726232, -1157661512, 0, 2094714012, 6, 3, 4, 9, 4 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 5;

    static int d = -504823565;

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
        new MyJVMTest_8235().test_2vi_aln(a, b, c, d);
    }
}
