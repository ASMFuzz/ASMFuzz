import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_6342 {

    static int[] aParam1 = { 7, 2070831294, 0, 170691244, 5, 8, 0, 0, 0, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 873;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    AtomicIntegerArray test_2ci_aln(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - ALIGN_OFF; i += 1) {
            a.compareAndSet((i + ALIGN_OFF), -1, -123);
            b.getAndSet(i, -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6342().test_2ci_aln(a, b);
    }
}
