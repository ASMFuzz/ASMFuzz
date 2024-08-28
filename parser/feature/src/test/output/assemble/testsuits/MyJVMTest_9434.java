import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_9434 {

    static int[] aParam1 = { 4, 0, -1740320196, 406247567, 8, 8, 8, 5, 0, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = 0;

    static int old = 0;

    static int ARRLEN = 97;

    int test_vi(AtomicIntegerArray a, int b, int old) {
        for (int i = 0; i < ARRLEN; i += 1) {
            a.compareAndSet(i, old, b);
        }
        return old;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9434().test_vi(a, b, old);
    }
}
