import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_12364 {

    static int aParam1 = 745;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { -88716606, -260163592, 5, 2094119805, 7, 5, 377187698, 0, 1, 0 };

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
        new MyJVMTest_12364().test_cp_unalnsrc(a, b);
    }
}
