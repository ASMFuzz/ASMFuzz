import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_13863 {

    static int aParam1 = 587;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 4, 1, 2, -695828407, -406616332, 8, 1, 0, 1851058411, 7 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    int test_2ci_oppos(AtomicIntegerArray a, AtomicIntegerArray b) {
        int limit = ARRLEN - 1;
        for (int i = 0; i < ARRLEN; i += 1) {
            a.set((limit - i), -123);
            b.set(i, -103);
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13863().test_2ci_oppos(a, b);
    }
}
