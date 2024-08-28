import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_7541 {

    static int aParam1 = 251;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 243;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int OFFSET = 3;

    AtomicIntegerArray test_2ci_off(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - OFFSET; i += 1) {
            a.compareAndSet((i + OFFSET), 123, -123);
            b.compareAndSet((i + OFFSET), 123, -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7541().test_2ci_off(a, b);
    }
}
