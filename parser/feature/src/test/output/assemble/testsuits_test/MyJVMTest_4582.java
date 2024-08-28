import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_4582 {

    static int[] aParam1 = { 148788535, 1, 5, 0, 0, 4, 6, 0, 1, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 7, 405819984, 1, 645914911, 4, 1012869420, 0, 0, 0, 0 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int k = 4;

    static int ARRLEN = 97;

    int test_cp_inv(AtomicIntegerArray a, AtomicIntegerArray b, int k) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.lazySet((i + k), b.get(i + k));
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4582().test_cp_inv(a, b, k);
    }
}
