import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_2303 {

    static int[] aParam1 = { 157597459, 0, 5, 6, 1272579210, 0, 4, 0, 9, 6 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int old = 0;

    static int ARRLEN = 97;

    int test_ci_oppos(AtomicIntegerArray a, int old) {
        int limit = ARRLEN - 1;
        for (int i = 0; i < ARRLEN; i += 1) {
            a.compareAndSet((limit - i), old, -123);
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2303().test_ci_oppos(a, old);
    }
}
