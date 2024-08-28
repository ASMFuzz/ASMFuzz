import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_10719 {

    static int aParam1 = 374;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, 1329293241, 0, 0, 1369937823, -1138657912, 8, 2, 4, 2 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int SCALE = 2;

    AtomicIntegerArray test_cp_scl(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i * SCALE < ARRLEN; i += 1) {
            a.compareAndSet((i * SCALE), -123, b.get(i * SCALE));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10719().test_cp_scl(a, b);
    }
}
