import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_15494 {

    static int aParam1 = 664;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 171;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int SCALE = 2;

    AtomicIntegerArray test_2ci_scl(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i * SCALE < ARRLEN; i += 1) {
            a.compareAndSet((i * SCALE), 123, -123);
            b.compareAndSet((i * SCALE), 123, -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15494().test_2ci_scl(a, b);
    }
}
