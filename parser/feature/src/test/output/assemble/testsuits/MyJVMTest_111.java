import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_111 {

    static int[] aParam1 = { 4, 3, -1938913892, 0, 0, 0, 0, 0, 0, 8 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = -2075979399;

    static int old = 2112389864;

    static int ARRLEN = 97;

    static int OFFSET = 3;

    int test_vi_off(AtomicIntegerArray a, int b, int old) {
        for (int i = 0; i < ARRLEN - OFFSET; i += 1) {
            a.compareAndSet((i + OFFSET), old, b);
        }
        return old;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_111().test_vi_off(a, b, old);
    }
}
