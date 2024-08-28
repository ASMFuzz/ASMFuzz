import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_10969 {

    static int[] aParam1 = { -1728875430, 404316509, 0, 0, 786907638, 0, 0, 0, 0, 4 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 420695894, 8, 0, 5, 2, 319920802, 1228657429, 1, 1, 6 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 359156547;

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
        new MyJVMTest_10969().test_2vi_oppos(a, b, c, d);
    }
}
