import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_1291 {

    static int[] aParam1 = { 5, 6, 0, -588512444, 9, 0, 765360747, 0, 0, 9 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { -1913888789, 0, -2103344299, 0, 5, 8, 8, 0, 3, 6 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    int test_cp_oppos(AtomicIntegerArray a, AtomicIntegerArray b) {
        int limit = ARRLEN - 1;
        for (int i = 0; i < ARRLEN; i += 1) {
            a.compareAndSet(i, -123, b.get(limit - i));
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1291().test_cp_oppos(a, b);
    }
}
