import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_9962 {

    static int aParam1 = 783;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = 1;

    static int old = 0;

    static int ARRLEN = 97;

    int test_vi_neg(AtomicIntegerArray a, int b, int old) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.compareAndSet(i, old, b);
        }
        return old;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9962().test_vi_neg(a, b, old);
    }
}
