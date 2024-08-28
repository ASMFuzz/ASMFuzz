import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_4692 {

    static int aParam1 = 811;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 982;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 0;

    static int d = 9;

    static int ARRLEN = 97;

    int test_2vi(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        for (int i = 0; i < ARRLEN; i += 1) {
            a.lazySet(i, c);
            b.lazySet(i, d);
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4692().test_2vi(a, b, c, d);
    }
}
