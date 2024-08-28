import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_5416 {

    static int aParam1 = 198;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 836;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = -746136725;

    static int d = 3;

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    int test_2vi_aln(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        for (int i = 0; i < ARRLEN - ALIGN_OFF; i += 1) {
            a.set(i, c);
            b.set((i + ALIGN_OFF), d);
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5416().test_2vi_aln(a, b, c, d);
    }
}
