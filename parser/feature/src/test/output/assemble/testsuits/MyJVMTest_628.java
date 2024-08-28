import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_628 {

    static int[] aParam1 = { -454250678, -1234923522, 8, 0, 7, 0, 6, 7, 5, 1 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 817;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    int test_cp_oppos(AtomicIntegerArray a, AtomicIntegerArray b) {
        int limit = ARRLEN - 1;
        for (int i = 0; i < ARRLEN; i += 1) {
            a.set(i, b.get(limit - i));
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_628().test_cp_oppos(a, b);
    }
}
