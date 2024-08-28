import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_8002 {

    static int[] aParam1 = { -2108706661, 0, 1399929502, 9, 9, 9, -790875656, 2, -572706631, 3 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 704;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int SCALE = 2;

    AtomicIntegerArray test_2ci_scl(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i * SCALE < ARRLEN; i += 1) {
            a.set((i * SCALE), -123);
            b.set((i * SCALE), -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8002().test_2ci_scl(a, b);
    }
}
