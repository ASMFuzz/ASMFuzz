import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_9688 {

    static int aParam1 = 887;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 9, -1150171388, 3, 7, 5, 0, 0, 0, 0, 0 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    AtomicIntegerArray test_2ci(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN; i += 1) {
            a.compareAndSet(i, 123, -123);
            b.compareAndSet(i, 123, -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9688().test_2ci(a, b);
    }
}
