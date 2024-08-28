import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_10495 {

    static int[] aParam1 = { -207305538, 1656012213, 0, 303626126, 0, 6, 0, 9, 0, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 582;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    int test_cp_oppos(AtomicIntegerArray a, AtomicIntegerArray b) {
        int limit = ARRLEN - 1;
        for (int i = 0; i < ARRLEN; i += 1) {
            a.compareAndSet(i, -123, b.get(limit - i));
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10495().test_cp_oppos(a, b);
    }
}
