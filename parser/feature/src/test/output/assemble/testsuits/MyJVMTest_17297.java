import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_17297 {

    static int aParam1 = 677;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = 6;

    static int old = 0;

    static int ARRLEN = 97;

    int test_vi_oppos(AtomicIntegerArray a, int b, int old) {
        int limit = ARRLEN - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a.set((limit - i), b);
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17297().test_vi_oppos(a, b, old);
    }
}
