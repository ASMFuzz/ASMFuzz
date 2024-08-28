import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_14999 {

    static int aParam1 = 155;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 1258950441, 0, 3, 2, 8, 3, 0, 0, 5, 4 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int OFFSET = 3;

    AtomicIntegerArray test_cp_off(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - OFFSET; i += 1) {
            a.lazySet((i + OFFSET), b.get(i + OFFSET));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14999().test_cp_off(a, b);
    }
}
