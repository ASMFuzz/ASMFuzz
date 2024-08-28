import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_15928 {

    static int[] aParam1 = { 5, 4, 2, 3, 0, 0, -1301570074, 1466516823, 0, 6 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 702;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 4;

    static int d = 9;

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
        new MyJVMTest_15928().test_2vi_off(a, b, c, d);
    }
}
