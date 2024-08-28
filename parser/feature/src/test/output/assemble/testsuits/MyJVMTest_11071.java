import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_11071 {

    static int aParam1 = 125;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 383;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int k = -1771761252;

    static int ARRLEN = 97;

    int test_2ci_inv(AtomicIntegerArray a, AtomicIntegerArray b, int k) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.lazySet((i + k), -123);
            b.lazySet((i + k), -103);
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11071().test_2ci_inv(a, b, k);
    }
}
