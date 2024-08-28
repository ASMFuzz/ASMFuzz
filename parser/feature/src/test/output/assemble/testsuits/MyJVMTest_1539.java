import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_1539 {

    static int[] aParam1 = { -1430106452, 6, 4, 0, 2, 0, 0, 0, 5, 2042202700 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, 0, 1, 0, 0, -229089432, 4, -499873959, 4, 5 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    int test_2ci_oppos(AtomicIntegerArray a, AtomicIntegerArray b) {
        int limit = ARRLEN - 1;
        for (int i = 0; i < ARRLEN; i += 1) {
            a.compareAndSet((limit - i), 123, -123);
            b.compareAndSet(i, 123, -103);
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1539().test_2ci_oppos(a, b);
    }
}
