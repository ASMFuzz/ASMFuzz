import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_16732 {

    static int aParam1 = 648;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 4, -915388941, 9, 0, 7, 2, 0, -380040293, 5, 3 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 1138353453;

    static int d = 0;

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
        new MyJVMTest_16732().test_2vi_scl(a, b, c, d);
    }
}
