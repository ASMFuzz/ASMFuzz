import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_9382 {

    static int[] aParam1 = { 0, 7, 2, 7, -1733272570, 1, -228829992, 9, 0, 3 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 81;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = -1812637076;

    static int d = 0;

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
        new MyJVMTest_9382().test_2vi_aln(a, b, c, d);
    }
}
