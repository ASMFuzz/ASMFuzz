import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_16074 {

    static int[] aParam1 = { 9, -1335059880, 1716117872, 9, -849916674, 2, -583847479, 3, 0, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 1, 0, 8, 8, 3, 7, -2039420279, 6, 1, 5 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    AtomicIntegerArray test_2ci_aln(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - ALIGN_OFF; i += 1) {
            a.lazySet((i + ALIGN_OFF), -123);
            b.lazySet(i, -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16074().test_2ci_aln(a, b);
    }
}
