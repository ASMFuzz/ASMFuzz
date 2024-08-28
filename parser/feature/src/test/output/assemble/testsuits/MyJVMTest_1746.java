import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_1746 {

    static int aParam1 = 955;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 660;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = -2101750215;

    static int d = 0;

    static int ARRLEN = 97;

    int test_2vi_oppos(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        int limit = ARRLEN - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a.compareAndSet(i, -123, c);
            b.compareAndSet((limit - i), -103, d);
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1746().test_2vi_oppos(a, b, c, d);
    }
}
