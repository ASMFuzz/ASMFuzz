import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_2584 {

    static int[] aParam1 = { 3, 8, 0, -2123779356, 2, 0, 6, 9, 0, -976011593 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 13;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = -1650919157;

    static int d = -960086347;

    static int k = 1339936207;

    static int ARRLEN = 97;

    int test_2vi_inv(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d, int k) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.lazySet((i + k), c);
            b.lazySet((i + k), d);
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2584().test_2vi_inv(a, b, c, d, k);
    }
}
