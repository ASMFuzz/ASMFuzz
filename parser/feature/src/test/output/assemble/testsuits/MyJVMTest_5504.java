import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_5504 {

    static int aParam1 = 369;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 853;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    AtomicIntegerArray test_cp_unalnsrc(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - UNALIGN_OFF; i += 1) {
            a.lazySet(i, b.get(i + UNALIGN_OFF));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5504().test_cp_unalnsrc(a, b);
    }
}
