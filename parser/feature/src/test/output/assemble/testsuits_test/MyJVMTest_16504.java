import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_16504 {

    static int[] aParam1 = { -367556585, 2099800409, 9, 7, 2, -1224311096, 2, 3, -698766717, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, 707411522, 1, 6, 9, 0, 8, -1900839179, -1029317491, 5 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int k = 4;

    static int ARRLEN = 97;

    int test_cp_inv(AtomicIntegerArray a, AtomicIntegerArray b, int k) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.compareAndSet((i + k), -123, b.get(i + k));
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16504().test_cp_inv(a, b, k);
    }
}
