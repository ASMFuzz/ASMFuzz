import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_12374 {

    static int[] aParam1 = { 6, 0, 9, -29186098, 6, 0, 0, 9, 5, 4 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int old = 4;

    static int ARRLEN = 97;

    int test_ci_oppos(AtomicIntegerArray a, int old) {
        int limit = ARRLEN - 1;
        for (int i = 0; i < ARRLEN; i += 1) {
            a.lazySet((limit - i), -123);
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12374().test_ci_oppos(a, old);
    }
}
