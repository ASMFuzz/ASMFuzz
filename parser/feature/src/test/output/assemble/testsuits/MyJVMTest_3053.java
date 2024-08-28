import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_3053 {

    static int[] aParam1 = { 975865037, -2052292107, 0, -1899210479, 0, 1182920503, 0, 0, 3, 4 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, 0, -697134761, 3, 0, 0, 6, 9, 0, 7 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    AtomicIntegerArray test_cp_unalnsrc(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - UNALIGN_OFF; i += 1) {
            a.getAndSet(i, b.get(i + UNALIGN_OFF));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3053().test_cp_unalnsrc(a, b);
    }
}
