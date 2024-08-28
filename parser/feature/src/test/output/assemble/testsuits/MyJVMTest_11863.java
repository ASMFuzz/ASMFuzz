import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_11863 {

    static int[] aParam1 = { 0, 1900999335, 0, 9, 0, 5, 3, -1822360480, 1, 1499844948 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 940;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 1;

    static int d = 5;

    static int k = -330809543;

    static int ARRLEN = 97;

    int test_2vi_inv(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d, int k) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.lazySet((i + k), c);
            b.lazySet((i + k), d);
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11863().test_2vi_inv(a, b, c, d, k);
    }
}
