import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_7743 {

    static int[] aParam1 = { 6, 1025479402, 0, 3, 0, 0, 8, -957278886, 4, 509020243 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = 9;

    static int old = -1583932936;

    static int ARRLEN = 97;

    int test_vi_oppos(AtomicIntegerArray a, int b, int old) {
        int limit = ARRLEN - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a.set((limit - i), b);
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7743().test_vi_oppos(a, b, old);
    }
}
