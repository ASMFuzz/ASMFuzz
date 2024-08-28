import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_4014 {

    static int aParam1 = 377;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 4, 7, 0, -792910428, 4, 9, 3, -1985672343, 1110520361, 1158293840 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    AtomicIntegerArray test_2ci_neg(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.compareAndSet(i, 123, -123);
            b.compareAndSet(i, 123, -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4014().test_2ci_neg(a, b);
    }
}
