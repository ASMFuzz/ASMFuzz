import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_1502 {

    static int aParam1 = 157;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 9, 8, 5, 895395665, 0, 0, 0, 2, 8, -1538593928 };

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
        new MyJVMTest_1502().test_cp_scl(a, b);
    }
}
