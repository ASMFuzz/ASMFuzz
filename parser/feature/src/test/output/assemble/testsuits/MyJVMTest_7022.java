import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_7022 {

    static int[] aParam1 = { 0, 9, 9, 0, 0, 0, 6, 2, 0, 6 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 3, 6, -1056985632, 0, -549784273, -1594064984, 3, 1549452002, 8, 1336215554 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    AtomicIntegerArray test_cp(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN; i += 1) {
            a.compareAndSet(i, -123, b.get(i));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7022().test_cp(a, b);
    }
}
