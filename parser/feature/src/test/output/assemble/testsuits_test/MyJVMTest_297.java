import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_297 {

    static int aParam1 = 800;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = 0;

    static int old = 979456143;

    static int ARRLEN = 97;

    static int OFFSET = 3;

    int test_vi_off(AtomicIntegerArray a, int b, int old) {
        for (int i = 0; i < ARRLEN - OFFSET; i += 1) {
            a.lazySet((i + OFFSET), b);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_297().test_vi_off(a, b, old);
    }
}
