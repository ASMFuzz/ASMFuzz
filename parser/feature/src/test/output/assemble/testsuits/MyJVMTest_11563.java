import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_11563 {

    static int aParam1 = 939;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int old = 7;

    static int ARRLEN = 97;

    int test_ci_oppos(AtomicIntegerArray a, int old) {
        int limit = ARRLEN - 1;
        for (int i = 0; i < ARRLEN; i += 1) {
            a.compareAndSet((limit - i), old, -123);
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11563().test_ci_oppos(a, old);
    }
}
