import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_6211 {

    static int aParam1 = 460;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 6, 0, 0, 4, -1485325953, 0, 3, 0, -1683108573, 0 };

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
        new MyJVMTest_6211().test_2ci_oppos(a, b);
    }
}
