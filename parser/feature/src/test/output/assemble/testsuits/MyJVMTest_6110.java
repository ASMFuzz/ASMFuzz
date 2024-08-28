import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_6110 {

    static int aParam1 = 493;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = 1113753900;

    static int old = 0;

    static int ARRLEN = 97;

    int test_vi(AtomicIntegerArray a, int b, int old) {
        for (int i = 0; i < ARRLEN; i += 1) {
            a.lazySet(i, b);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6110().test_vi(a, b, old);
    }
}
