import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_12705 {

    static int aParam1 = 195;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 808;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = -1443559623;

    static int d = 499610185;

    static int ARRLEN = 97;

    static int SCALE = 2;

    int test_2vi_scl(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        for (int i = 0; i * SCALE < ARRLEN; i += 1) {
            a.compareAndSet((i * SCALE), -123, c);
            b.compareAndSet((i * SCALE), -103, d);
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12705().test_2vi_scl(a, b, c, d);
    }
}
