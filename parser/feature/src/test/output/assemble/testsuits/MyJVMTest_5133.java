import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_5133 {

    static int[] aParam1 = { -714712325, 0, 0, 2, 8, 3, 1079364425, 0, -857701403, 7 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = 1440254269;

    static int k = -623311376;

    static int old = 1723302531;

    static int ARRLEN = 97;

    int test_vi_inv(AtomicIntegerArray a, int b, int k, int old) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.compareAndSet((i + k), old, b);
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5133().test_vi_inv(a, b, k, old);
    }
}
