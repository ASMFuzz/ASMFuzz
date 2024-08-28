import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_10759 {

    static int[] aParam1 = { 3, 6, 9, 3, 0, 1840012700, -1165877500, 1, 9, 4 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 9, 3, 4, 0, 0, 5, 1328539407, 1202507827, 0, 9 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    int test_2ci_oppos(AtomicIntegerArray a, AtomicIntegerArray b) {
        int limit = ARRLEN - 1;
        for (int i = 0; i < ARRLEN; i += 1) {
            a.compareAndSet((limit - i), 123, -123);
            b.compareAndSet(i, 123, -103);
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10759().test_2ci_oppos(a, b);
    }
}
