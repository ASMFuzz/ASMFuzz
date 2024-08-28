import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_15467 {

    static int aParam1 = 6;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = 1199423017;

    static int old = 4;

    static int ARRLEN = 97;

    int test_vi_oppos(AtomicIntegerArray a, int b, int old) {
        int limit = ARRLEN - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a.lazySet((limit - i), b);
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15467().test_vi_oppos(a, b, old);
    }
}
