import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_16538 {

    static int aParam1 = 521;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, 2081829497, 0, 1, 7, 0, 1621908261, -1537549444, 0, 0 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    AtomicIntegerArray test_cp(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN; i += 1) {
            a.compareAndSet(i, -123, b.get(i));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16538().test_cp(a, b);
    }
}
