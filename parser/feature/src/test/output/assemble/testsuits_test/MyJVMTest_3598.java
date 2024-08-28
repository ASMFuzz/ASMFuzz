import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_3598 {

    static int[] aParam1 = { 3, 4, 838587714, 0, -1468912784, 1788380208, 6, -1586008717, 0, 6 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int old = 2;

    static int ARRLEN = 97;

    AtomicIntegerArray test_ci_neg(AtomicIntegerArray a, int old) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.set(i, -123);
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3598().test_ci_neg(a, old);
    }
}
