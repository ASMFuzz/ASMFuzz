import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_3306 {

    static int aParam1 = 805;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 295;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    AtomicIntegerArray test_cp_alndst(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - ALIGN_OFF; i += 1) {
            a.compareAndSet((i + ALIGN_OFF), -1, b.get(i));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3306().test_cp_alndst(a, b);
    }
}
