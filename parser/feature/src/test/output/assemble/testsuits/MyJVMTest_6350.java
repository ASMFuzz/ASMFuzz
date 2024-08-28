import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_6350 {

    static int[] aParam1 = { 0, 2, 1277729530, 6, 0, -1438618043, 1, 0, 0, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 665;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    AtomicIntegerArray test_cp_unalndst(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - UNALIGN_OFF; i += 1) {
            a.compareAndSet((i + UNALIGN_OFF), -1, b.get(i));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6350().test_cp_unalndst(a, b);
    }
}
