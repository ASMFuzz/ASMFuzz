import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_9348 {

    static int aParam1 = 324;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { -824521552, 4, 5, 7, 0, 6, 4, -187186699, 8, 1176524454 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 8;

    static int d = 2019069896;

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
        new MyJVMTest_9348().test_2vi_oppos(a, b, c, d);
    }
}
