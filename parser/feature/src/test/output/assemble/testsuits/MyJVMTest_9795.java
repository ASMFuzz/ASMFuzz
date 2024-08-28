import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_9795 {

    static int[] aParam1 = { 9, 3, 6, 8, 0, 9, 5, 36714636, 7, 5 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 219248038, 5, 7, 0, 0, 0, -2055374215, 5, 0, 6 };

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
        new MyJVMTest_9795().test_cp_oppos(a, b);
    }
}
