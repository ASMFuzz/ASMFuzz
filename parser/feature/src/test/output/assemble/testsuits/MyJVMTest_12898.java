import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_12898 {

    static int aParam1 = 882;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 5, -1595109644, 0, 0, 9, 8, 3, -878325028, 3, -18405953 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 3;

    static int d = 4;

    static int ARRLEN = 97;

    static int OFFSET = 3;

    int test_2vi_off(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        for (int i = 0; i < ARRLEN - OFFSET; i += 1) {
            a.lazySet((i + OFFSET), c);
            b.lazySet((i + OFFSET), d);
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12898().test_2vi_off(a, b, c, d);
    }
}
