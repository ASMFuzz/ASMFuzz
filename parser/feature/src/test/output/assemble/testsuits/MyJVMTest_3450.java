import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_3450 {

    static int aParam1 = 980;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 822;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int OFFSET = 3;

    AtomicIntegerArray test_cp_off(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - OFFSET; i += 1) {
            a.compareAndSet((i + OFFSET), -123, b.get(i + OFFSET));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3450().test_cp_off(a, b);
    }
}
