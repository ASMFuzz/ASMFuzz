import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_12999 {

    static int aParam1 = 39;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 935;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    AtomicIntegerArray test_2ci(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN; i += 1) {
            a.lazySet(i, -123);
            b.lazySet(i, -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12999().test_2ci(a, b);
    }
}
