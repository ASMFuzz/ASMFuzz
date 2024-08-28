import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_1512 {

    static int[] aParam1 = { 1, 4, 6, 4, 0, 1, 3, 1, 0, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, 0, 1993848277, 2, 4, 0, 0, 2, 0, 2 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    AtomicIntegerArray test_cp(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN; i += 1) {
            a.set(i, b.get(i));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1512().test_cp(a, b);
    }
}
