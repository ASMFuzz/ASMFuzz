import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_832 {

    static int aParam1 = 774;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { -1528363149, 8, 8, 3, 1628541755, 0, 0, 0, 3, 0 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    AtomicIntegerArray test_2ci_unaln(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - UNALIGN_OFF; i += 1) {
            a.compareAndSet((i + UNALIGN_OFF), -1, -123);
            b.getAndSet(i, -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_832().test_2ci_unaln(a, b);
    }
}
