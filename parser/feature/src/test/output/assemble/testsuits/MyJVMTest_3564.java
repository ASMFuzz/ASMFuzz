import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_3564 {

    static int aParam1 = 477;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 549;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 0;

    static int d = 5;

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
        new MyJVMTest_3564().test_2vi_off(a, b, c, d);
    }
}
