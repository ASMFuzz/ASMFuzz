import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_7209 {

    static int aParam1 = 337;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, 0, 0, 0, 4, 0, 8, -1907204013, 6, 6 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 0;

    static int d = -711266118;

    static int ARRLEN = 97;

    static int SCALE = 2;

    int test_2vi_scl(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        for (int i = 0; i * SCALE < ARRLEN; i += 1) {
            a.lazySet((i * SCALE), c);
            b.lazySet((i * SCALE), d);
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7209().test_2vi_scl(a, b, c, d);
    }
}
