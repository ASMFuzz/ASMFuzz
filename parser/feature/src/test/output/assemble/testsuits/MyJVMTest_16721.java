import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_16721 {

    static int aParam1 = 861;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { -1031351809, 0, 0, -884299109, 6, 2, 0, 4, -274788848, 0 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 0;

    static int d = 8;

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
        new MyJVMTest_16721().test_2vi_unaln(a, b, c, d);
    }
}
