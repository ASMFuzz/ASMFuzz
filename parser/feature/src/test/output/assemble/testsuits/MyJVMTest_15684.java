import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_15684 {

    static int[] aParam1 = { 4, 0, 2, 2, 8, 7, -20937577, 0, 3, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 4, -1801296271, 6, 371034225, 5, 498777779, 0, 3, -1517333215, -1847679546 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    int test_2ci_oppos(AtomicIntegerArray a, AtomicIntegerArray b) {
        int limit = ARRLEN - 1;
        for (int i = 0; i < ARRLEN; i += 1) {
            a.lazySet((limit - i), -123);
            b.lazySet(i, -103);
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15684().test_2ci_oppos(a, b);
    }
}
