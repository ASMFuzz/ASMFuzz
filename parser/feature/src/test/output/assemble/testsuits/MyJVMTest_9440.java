import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_9440 {

    static int[] aParam1 = { -401216344, 4, 2097849982, 4, -237886426, 2072092717, 7, 4, -106270188, 6 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 887;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 0;

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
        new MyJVMTest_9440().test_2vi_scl(a, b, c, d);
    }
}
