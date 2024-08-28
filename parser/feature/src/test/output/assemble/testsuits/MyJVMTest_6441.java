import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_6441 {

    static int[] aParam1 = { 421749732, 4, 1384191493, 0, 0, 9, 682414211, 0, 0, 4 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, 0, 0, 1, 0, 1783780477, 4, 484258528, 0, -484736712 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = -1167532997;

    static int d = 0;

    static int ARRLEN = 97;

    static int OFFSET = 3;

    int test_2vi_off(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        for (int i = 0; i < ARRLEN - OFFSET; i += 1) {
            a.set((i + OFFSET), c);
            b.set((i + OFFSET), d);
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6441().test_2vi_off(a, b, c, d);
    }
}
