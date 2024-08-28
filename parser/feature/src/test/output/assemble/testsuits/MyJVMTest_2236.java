import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_2236 {

    static int[] aParam1 = { 0, 0, 6, -1787522656, 3, 2, -1632632786, 571154700, 8, 2 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 281;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 0;

    static int d = 0;

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
        new MyJVMTest_2236().test_2vi_off(a, b, c, d);
    }
}
