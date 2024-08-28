import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_12631 {

    static int[] aParam1 = { 827965768, 0, 2, 6, 6, -2117922235, 9, 0, 0, 416970049 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 2, 7, 7, 0, 1, 5, 0, -2100372210, 0, 1810901700 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    AtomicIntegerArray test_cp_alndst(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - ALIGN_OFF; i += 1) {
            a.compareAndSet((i + ALIGN_OFF), -1, b.get(i));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12631().test_cp_alndst(a, b);
    }
}
