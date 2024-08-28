import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_16414 {

    static int[] aParam1 = { 9, 571309889, 6, 1, 1465204703, -1276262493, 9, 0, 0, 7 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 208;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 0;

    static int d = 5;

    static int ARRLEN = 97;

    int test_2vi_oppos(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        int limit = ARRLEN - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a.set(i, c);
            b.set((limit - i), d);
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16414().test_2vi_oppos(a, b, c, d);
    }
}
