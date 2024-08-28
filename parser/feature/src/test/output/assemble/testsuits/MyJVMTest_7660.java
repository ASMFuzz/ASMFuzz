import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_7660 {

    static int[] aParam1 = { 3, 1636533580, 2, 0, 0, 0, 8, 1, 9, -49184004 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = -941091735;

    static int old = 0;

    static int ARRLEN = 97;

    static int SCALE = 2;

    int test_vi_scl(AtomicIntegerArray a, int b, int old) {
        for (int i = 0; i * SCALE < ARRLEN; i += 1) {
            a.lazySet((i * SCALE), b);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7660().test_vi_scl(a, b, old);
    }
}
