import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_17519 {

    static int aParam1 = 370;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 546;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 6;

    static int d = 9;

    static int ARRLEN = 97;

    int test_2vi_neg(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.set(i, c);
            b.set(i, d);
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17519().test_2vi_neg(a, b, c, d);
    }
}
