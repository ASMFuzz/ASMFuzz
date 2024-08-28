import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_15711 {

    static int aParam1 = 491;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, 0, 2, -1374008265, 8, 8, 9, 4, 0, 8 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 837008277;

    static int d = 4;

    static int k = 9;

    static int ARRLEN = 97;

    int test_2vi_inv(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d, int k) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.set((i + k), c);
            b.set((i + k), d);
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15711().test_2vi_inv(a, b, c, d, k);
    }
}
