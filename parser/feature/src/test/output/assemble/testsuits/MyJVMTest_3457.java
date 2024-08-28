import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_3457 {

    static int[] aParam1 = { 1, -1509241745, 0, 0, 0, 0, 8, 0, 540883349, -1012423250 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = -707376169;

    static int old = 0;

    static int ARRLEN = 97;

    int test_vi_neg(AtomicIntegerArray a, int b, int old) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.set(i, b);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3457().test_vi_neg(a, b, old);
    }
}
