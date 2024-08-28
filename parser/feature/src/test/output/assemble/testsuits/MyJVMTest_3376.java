import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_3376 {

    static int aParam1 = 941;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 543;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 3;

    static int d = 7;

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
        new MyJVMTest_3376().test_2vi_scl(a, b, c, d);
    }
}
