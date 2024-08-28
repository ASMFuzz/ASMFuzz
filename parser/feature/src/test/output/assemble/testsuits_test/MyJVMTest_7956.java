import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_7956 {

    static int aParam1 = 777;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, 0, 9, 1749129470, -1231168184, 0, 3, -69621417, 8, 0 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 9;

    static int d = 11176934;

    static int ARRLEN = 97;

    int test_2vi_neg(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.set(i, c);
            b.set(i, d);
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7956().test_2vi_neg(a, b, c, d);
    }
}
