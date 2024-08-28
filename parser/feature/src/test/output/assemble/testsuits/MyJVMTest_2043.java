import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_2043 {

    static int aParam1 = 226;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 8, 0, 0, 7, 2, 0, 9, -1623182091, 8, 5 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int OFFSET = 3;

    AtomicIntegerArray test_2ci_off(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - OFFSET; i += 1) {
            a.lazySet((i + OFFSET), -123);
            b.lazySet((i + OFFSET), -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2043().test_2ci_off(a, b);
    }
}
