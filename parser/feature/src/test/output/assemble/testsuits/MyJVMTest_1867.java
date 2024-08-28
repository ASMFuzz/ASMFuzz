import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_1867 {

    static int[] aParam1 = { -1216471001, 0, 5, 6, 3, 231481988, 0, 6, 0, 7 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int old = 5;

    static int ARRLEN = 97;

    static int SCALE = 2;

    AtomicIntegerArray test_ci_scl(AtomicIntegerArray a, int old) {
        for (int i = 0; i * SCALE < ARRLEN; i += 1) {
            a.lazySet((i * SCALE), -123);
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1867().test_ci_scl(a, old);
    }
}
