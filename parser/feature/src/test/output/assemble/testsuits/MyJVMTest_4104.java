import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_4104 {

    static int[] aParam1 = { 8, 5, 7, 2, 0, 7, 6, 9, -283178840, 1 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 829;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int c = 8;

    static int d = 1610121585;

    static int ARRLEN = 97;

    int test_2vi(AtomicIntegerArray a, AtomicIntegerArray b, int c, int d) {
        for (int i = 0; i < ARRLEN; i += 1) {
            a.set(i, c);
            b.set(i, d);
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4104().test_2vi(a, b, c, d);
    }
}
