import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_10835 {

    static int aParam1 = 804;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 4, 9, 0, 5, 0, 0, 4, 1840027020, 3, 3 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    AtomicIntegerArray test_cp(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN; i += 1) {
            a.lazySet(i, b.get(i));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10835().test_cp(a, b);
    }
}
