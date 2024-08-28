import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_14678 {

    static int aParam1 = 243;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 333;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    AtomicIntegerArray test_2ci_aln(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - ALIGN_OFF; i += 1) {
            a.set((i + ALIGN_OFF), -123);
            b.set(i, -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14678().test_2ci_aln(a, b);
    }
}
