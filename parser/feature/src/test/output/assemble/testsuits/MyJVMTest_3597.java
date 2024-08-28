import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_3597 {

    static int aParam1 = 302;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { -655800178, 2, -1383962943, 498018931, 0, 9, 0, -1461507316, 4, 7 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 1;

    static int d = 0;

    static int ARRLEN = 97;

    int test_2vi_neg(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.lazySet(i, c);
            b.lazySet(i, d);
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3597().test_2vi_neg(a, b, c, d);
    }
}
