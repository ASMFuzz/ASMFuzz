import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_774 {

    static int[] aParam1 = { 3, 191998732, 6, 0, 0, -994904282, 0, 2, 7, 2 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = -229257591;

    static int old = 0;

    static int ARRLEN = 97;

    static int OFFSET = 3;

    int test_vi_off(AtomicIntegerArray a, int b, int old) {
        for (int i = 0; i < ARRLEN - OFFSET; i += 1) {
            a.set((i + OFFSET), b);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_774().test_vi_off(a, b, old);
    }
}
