import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_9953 {

    static int[] aParam1 = { 587043960, 7, 0, 0, 9, -1103693118, 214681795, 0, 5, 3 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = 5;

    static int old = 1;

    static int ARRLEN = 97;

    static int OFFSET = 3;

    int test_vi_off(AtomicIntegerArray a, int b, int old) {
        for (int i = 0; i < ARRLEN - OFFSET; i += 1) {
            a.set((i + OFFSET), b);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9953().test_vi_off(a, b, old);
    }
}
