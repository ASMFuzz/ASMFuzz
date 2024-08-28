import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_13891 {

    static int aParam1 = 52;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = 0;

    static int old = 4;

    static int ARRLEN = 97;

    int test_vi(AtomicIntegerArray a, int b, int old) {
        for (int i = 0; i < ARRLEN; i += 1) {
            a.set(i, b);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13891().test_vi(a, b, old);
    }
}
