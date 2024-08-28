import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_7198 {

    static int[] aParam1 = { 4, -1648018211, 63100671, 1510190038, 2, 9, 0, 3, 8, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 916;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 0;

    static int d = 0;

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int test_2vi_unaln(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        for (int i = 0; i < ARRLEN - UNALIGN_OFF; i += 1) {
            a.lazySet(i, c);
            b.lazySet((i + UNALIGN_OFF), d);
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7198().test_2vi_unaln(a, b, c, d);
    }
}
