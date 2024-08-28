import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_2177 {

    static int aParam1 = 96;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 510;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    AtomicIntegerArray test_cp_neg(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.lazySet(i, b.get(i));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2177().test_cp_neg(a, b);
    }
}
