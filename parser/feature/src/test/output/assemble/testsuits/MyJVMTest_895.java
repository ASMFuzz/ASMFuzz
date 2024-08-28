import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_895 {

    static int aParam1 = 430;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 80;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 2;

    static int d = 8;

    static int ARRLEN = 97;

    int test_2vi_neg(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.compareAndSet(i, -123, c);
            b.compareAndSet(i, -103, d);
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_895().test_2vi_neg(a, b, c, d);
    }
}
