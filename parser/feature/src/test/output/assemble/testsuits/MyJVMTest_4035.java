import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_4035 {

    static int[] aParam1 = { 0, 0, 0, 0, 7, 1, 9, 181413367, 0, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 9, 1, 0, 7, 0, 2, 2, 8, -1732539800, 794055963 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    AtomicIntegerArray test_cp_unalnsrc(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - UNALIGN_OFF; i += 1) {
            a.set(i, b.get(i + UNALIGN_OFF));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4035().test_cp_unalnsrc(a, b);
    }
}
