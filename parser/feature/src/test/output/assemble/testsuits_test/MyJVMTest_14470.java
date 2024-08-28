import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_14470 {

    static int[] aParam1 = { 0, 5, 8, 522569042, 3, 788013534, 9, 1659555110, -185687395, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int old = 1231056510;

    static int ARRLEN = 97;

    static int OFFSET = 3;

    AtomicIntegerArray test_ci_off(AtomicIntegerArray a, int old) {
        for (int i = 0; i < ARRLEN - OFFSET; i += 1) {
            a.lazySet((i + OFFSET), -123);
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14470().test_ci_off(a, old);
    }
}
