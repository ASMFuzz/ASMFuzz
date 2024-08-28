import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_7832 {

    static int aParam1 = 970;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 284;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    AtomicIntegerArray test_cp_alnsrc(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - ALIGN_OFF; i += 1) {
            a.lazySet(i, b.get(i + ALIGN_OFF));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7832().test_cp_alnsrc(a, b);
    }
}
