import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_5959 {

    static int[] aParam1 = { 5, 0, -354372135, 293258866, 0, 7, 1, 5, 0, 6 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int old = 0;

    static int ARRLEN = 97;

    int test_ci_oppos(AtomicIntegerArray a, int old) {
        int limit = ARRLEN - 1;
        for (int i = 0; i < ARRLEN; i += 1) {
            a.set((limit - i), -123);
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5959().test_ci_oppos(a, old);
    }
}
