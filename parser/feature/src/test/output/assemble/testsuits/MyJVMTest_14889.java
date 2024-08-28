import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_14889 {

    static int[] aParam1 = { -1713824563, 1770018075, -1764384162, 8, -1847285671, 2, 0, 0, 5, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 3, 6, 7, 6, 0, 0, 838808263, 1588406381, 1342790712, 0 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int OFFSET = 3;

    AtomicIntegerArray test_cp_off(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - OFFSET; i += 1) {
            a.set((i + OFFSET), b.get(i + OFFSET));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14889().test_cp_off(a, b);
    }
}
