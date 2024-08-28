import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_12795 {

    static int[] aParam1 = { -1449078837, 0, 6, 4, 0, 0, 0, 3, -1259743330, -218434812 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 425;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int SCALE = 2;

    AtomicIntegerArray test_cp_scl(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i * SCALE < ARRLEN; i += 1) {
            a.lazySet((i * SCALE), b.get(i * SCALE));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12795().test_cp_scl(a, b);
    }
}
