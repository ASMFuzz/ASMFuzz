import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_6012 {

    static int[] aParam1 = { 0, 1, 2, -493789835, 4, 5, 0, 0, 0, -529496020 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = 0;

    static int old = -283344326;

    static int ARRLEN = 97;

    int test_vi_oppos(AtomicIntegerArray a, int b, int old) {
        int limit = ARRLEN - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a.lazySet((limit - i), b);
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6012().test_vi_oppos(a, b, old);
    }
}
