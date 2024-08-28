import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_231 {

    static int aParam1 = 480;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 6, 8, 2, 8, 0, 1, 9, 3, 9, 0 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 9;

    static int d = 6;

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    int test_2vi_aln(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        for (int i = 0; i < ARRLEN - ALIGN_OFF; i += 1) {
            a.getAndSet(i, c);
            b.getAndSet((i + ALIGN_OFF), d);
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_231().test_2vi_aln(a, b, c, d);
    }
}
