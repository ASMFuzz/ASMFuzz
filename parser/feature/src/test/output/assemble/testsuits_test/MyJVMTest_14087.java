import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_14087 {

    static int[] aParam1 = { 859393631, 4, -1065913212, 716080580, -1838421314, 4, 1, 1407923012, 0, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, 0, 1131815204, 0, 0, 8, 5, 2, 0, 1434712932 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 1089430879;

    static int d = 3;

    static int ARRLEN = 97;

    int test_2vi(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        for (int i = 0; i < ARRLEN; i += 1) {
            a.lazySet(i, c);
            b.lazySet(i, d);
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14087().test_2vi(a, b, c, d);
    }
}
