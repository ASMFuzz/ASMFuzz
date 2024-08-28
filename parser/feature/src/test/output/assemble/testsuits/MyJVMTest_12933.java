import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_12933 {

    static int[] aParam1 = { 5, 6, 0, 8, 926962779, -543454085, 5, 9, 1437382021, 2 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int old = 172146899;

    static int ARRLEN = 97;

    AtomicIntegerArray test_ci_neg(AtomicIntegerArray a, int old) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.set(i, -123);
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12933().test_ci_neg(a, old);
    }
}
