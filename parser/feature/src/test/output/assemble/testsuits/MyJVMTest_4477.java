import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_4477 {

    static int[] aParam1 = { 0, 4, 1005215251, 4, 0, 8, 8, 0, -2051902108, -228312146 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 511;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    int test_2ci_oppos(AtomicIntegerArray a, AtomicIntegerArray b) {
        int limit = ARRLEN - 1;
        for (int i = 0; i < ARRLEN; i += 1) {
            a.set((limit - i), -123);
            b.set(i, -103);
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4477().test_2ci_oppos(a, b);
    }
}
