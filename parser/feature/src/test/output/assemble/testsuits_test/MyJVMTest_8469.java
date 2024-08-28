import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_8469 {

    static int[] aParam1 = { 0, -627748676, 0, 0, 6, 6, 0, 0, 764208928, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 82311444, 0, 6, 7, 1204259277, 4, 0, 0, 0, 0 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int SCALE = 2;

    AtomicIntegerArray test_cp_scl(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i * SCALE < ARRLEN; i += 1) {
            a.set((i * SCALE), b.get(i * SCALE));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8469().test_cp_scl(a, b);
    }
}
