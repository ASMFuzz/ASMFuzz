import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_288 {

    static int aParam1 = 579;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 4, 0, -1205723719, 0, -1597429986, 3, -1975367757, 0, 8, 2 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 3;

    static int d = 0;

    static int ARRLEN = 97;

    static int SCALE = 2;

    int test_2vi_scl(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        for (int i = 0; i * SCALE < ARRLEN; i += 1) {
            a.set((i * SCALE), c);
            b.set((i * SCALE), d);
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_288().test_2vi_scl(a, b, c, d);
    }
}
