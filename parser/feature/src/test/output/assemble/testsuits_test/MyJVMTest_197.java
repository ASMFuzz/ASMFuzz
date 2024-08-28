import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_197 {

    static int aParam1 = 397;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 9, 8, 7, 3, 0, 7, -367885780, 0, 5, 1 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 0;

    static int d = 0;

    static int ARRLEN = 97;

    int test_2vi_oppos(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        int limit = ARRLEN - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a.lazySet(i, c);
            b.lazySet((limit - i), d);
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_197().test_2vi_oppos(a, b, c, d);
    }
}
