import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_2731 {

    static int[] aParam1 = { 1154225379, -495836658, 9, 3, 2, -485451111, 6, 8, 7, 7 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, 0, 0, 0, 684431020, 0, 0, 9, 9, 3 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    AtomicIntegerArray test_cp_neg(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.set(i, b.get(i));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2731().test_cp_neg(a, b);
    }
}
