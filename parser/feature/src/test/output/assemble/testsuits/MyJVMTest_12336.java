import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_12336 {

    static int[] aParam1 = { 0, 1, 2, 440477258, 6, 0, 4, 0, 0, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 8, -274354601, -565442319, 2, -1261575433, 4, 3, -798696041, 9, 5 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    int test_cp_oppos(AtomicIntegerArray a, AtomicIntegerArray b) {
        int limit = ARRLEN - 1;
        for (int i = 0; i < ARRLEN; i += 1) {
            a.lazySet(i, b.get(limit - i));
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12336().test_cp_oppos(a, b);
    }
}
