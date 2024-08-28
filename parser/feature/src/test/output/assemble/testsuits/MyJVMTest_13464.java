import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_13464 {

    static int aParam1 = 457;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, 0, -845190974, 4, 978850241, 7, 0, 0, 6, 0 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = -1546453740;

    static int d = 0;

    static int ARRLEN = 97;

    int test_2vi(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        for (int i = 0; i < ARRLEN; i += 1) {
            a.set(i, c);
            b.set(i, d);
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13464().test_2vi(a, b, c, d);
    }
}
