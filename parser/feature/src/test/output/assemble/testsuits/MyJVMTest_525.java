import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_525 {

    static int[] aParam1 = { 0, 1698802065, 457694202, 0, -240044714, 1, 7, 6, 255381638, 9 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 6, 0, 4, 0, 1808257957, 5, 4, 0, 0, 2 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    AtomicIntegerArray test_2ci(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN; i += 1) {
            a.compareAndSet(i, 123, -123);
            b.compareAndSet(i, 123, -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_525().test_2ci(a, b);
    }
}
