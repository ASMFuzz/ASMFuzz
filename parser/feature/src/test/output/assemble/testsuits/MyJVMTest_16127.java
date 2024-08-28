import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_16127 {

    static int aParam1 = 834;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, 0, 0, -1069416637, 0, 4, -1868260602, 0, 7, 2 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 4;

    static int d = -194615886;

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int test_2vi_unaln(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        for (int i = 0; i < ARRLEN - UNALIGN_OFF; i += 1) {
            a.getAndSet(i, c);
            b.getAndSet((i + UNALIGN_OFF), d);
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16127().test_2vi_unaln(a, b, c, d);
    }
}
