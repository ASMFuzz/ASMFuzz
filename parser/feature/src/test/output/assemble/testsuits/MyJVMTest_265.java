import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_265 {

    static int aParam1 = 981;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 344;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    AtomicIntegerArray test_cp_alnsrc(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - ALIGN_OFF; i += 1) {
            a.getAndSet(i, b.get(i + ALIGN_OFF));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_265().test_cp_alnsrc(a, b);
    }
}
