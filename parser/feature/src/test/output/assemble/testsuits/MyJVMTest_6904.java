import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_6904 {

    static int[] aParam1 = { 4, 9, 0, -1884659511, 0, 9, -596000877, -1216104382, 6, 3 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, 1, 0, 0, 0, 0, 0, 0, -2131188313, 0 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 256170740;

    static int d = -418499982;

    static int ARRLEN = 97;

    int test_2vi_oppos(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        int limit = ARRLEN - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a.set(i, c);
            b.set((limit - i), d);
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6904().test_2vi_oppos(a, b, c, d);
    }
}
