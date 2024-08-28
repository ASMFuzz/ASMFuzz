import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_13972 {

    static int[] aParam1 = { 1683041990, 0, 1, 1961216078, -2070560672, 4, -163675046, 4, 1, 1803364938 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, 0, 0, 3, 1, 0, 596089266, 0, 8, -1201466462 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int k = 0;

    static int ARRLEN = 97;

    int test_cp_inv(AtomicIntegerArray a, AtomicIntegerArray b, int k) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.lazySet((i + k), b.get(i + k));
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13972().test_cp_inv(a, b, k);
    }
}
