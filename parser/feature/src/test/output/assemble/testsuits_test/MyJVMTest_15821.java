import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_15821 {

    static int[] aParam1 = { 8, 1149949700, 0, 0, 881889492, 0, 1, 4, 1, 1548365669 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 1286084920, 7, 8, 0, 2, 7, -74037048, 0, 1, 2 };

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
        new MyJVMTest_15821().test_2ci_aln(a, b);
    }
}
