import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_11491 {

    static int[] aParam1 = { 9, 4, 9, 6, 3, 6, 4, 5, 2118907956, -1112468711 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 294;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 5;

    static int d = 4;

    static int ARRLEN = 97;

    static int OFFSET = 3;

    int test_2vi_off(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        for (int i = 0; i < ARRLEN - OFFSET; i += 1) {
            a.compareAndSet((i + OFFSET), -123, c);
            b.compareAndSet((i + OFFSET), -103, d);
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11491().test_2vi_off(a, b, c, d);
    }
}
