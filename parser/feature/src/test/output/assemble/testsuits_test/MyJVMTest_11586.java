import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_11586 {

    static int[] aParam1 = { 5, -168732254, 1, 1118632291, 0, 3, 1, 1, 9, 8 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { -1742337684, 0, -601957327, 8, 5, 8, 3, 8, 6, 0 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    AtomicIntegerArray test_cp_neg(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.compareAndSet(i, -123, b.get(i));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11586().test_cp_neg(a, b);
    }
}
