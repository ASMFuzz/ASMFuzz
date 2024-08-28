import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_6631 {

    static int aParam1 = 354;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 271;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 3;

    static int d = 244333841;

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
        new MyJVMTest_6631().test_2vi_unaln(a, b, c, d);
    }
}
