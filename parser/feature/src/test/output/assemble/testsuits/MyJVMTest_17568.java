import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_17568 {

    static int[] aParam1 = { 9, 0, -2005233914, 3, 0, 3, 1, 5, -138152342, 8 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 2, 9, -200466304, -660906296, 0, -742082801, 6, 0, 0, 0 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int SCALE = 2;

    AtomicIntegerArray test_2ci_scl(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i * SCALE < ARRLEN; i += 1) {
            a.set((i * SCALE), -123);
            b.set((i * SCALE), -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17568().test_2ci_scl(a, b);
    }
}
