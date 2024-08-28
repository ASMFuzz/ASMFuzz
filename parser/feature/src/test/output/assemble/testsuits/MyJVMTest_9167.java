import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_9167 {

    static int[] aParam1 = { 5, 0, 0, 1098688123, 1076957242, 5, 0, -788358167, 7, 1 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int k = 4;

    static int old = 6;

    static int ARRLEN = 97;

    int test_ci_inv(AtomicIntegerArray a, int k, int old) {
        for (int i = 0; i < ARRLEN - k; i += 1) {
            a.set((i + k), -123);
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9167().test_ci_inv(a, k, old);
    }
}
