import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_9256 {

    static int[] aParam1 = { 781656302, 1, 6, 7, 562246523, 0, 0, 1215544310, 7, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = 7;

    static int old = 0;

    static int ARRLEN = 97;

    static int OFFSET = 3;

    int test_vi_off(AtomicIntegerArray a, int b, int old) {
        for (int i = 0; i < ARRLEN - OFFSET; i += 1) {
            a.compareAndSet((i + OFFSET), old, b);
        }
        return old;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9256().test_vi_off(a, b, old);
    }
}
