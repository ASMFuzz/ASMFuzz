import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_6238 {

    static int aParam1 = 769;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { -1558576406, 1360834239, 1898018682, 8, 0, 0, -1079554670, 9, 2040457994, 147984360 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 9;

    static int d = 4;

    static int k = -444618407;

    static int ARRLEN = 97;

    int test_2vi_inv(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d, int k) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.set((i + k), c);
            b.set((i + k), d);
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6238().test_2vi_inv(a, b, c, d, k);
    }
}
