import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_4504 {

    static int[] aParam1 = { 0, 0, 3, 9, 3, 5, 0, 1065440117, 8, -888312559 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = 0;

    static int old = 3;

    static int ARRLEN = 97;

    int test_vi(AtomicIntegerArray a, int b, int old) {
        for (int i = 0; i < ARRLEN; i += 1) {
            a.set(i, b);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4504().test_vi(a, b, old);
    }
}
