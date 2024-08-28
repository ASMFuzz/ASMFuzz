import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_314 {

    static int aParam1 = 208;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 3, 8, 0, 7, 9, 5, 0, 4, 624505480, 0 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int SCALE = 2;

    AtomicIntegerArray test_2ci_scl(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i * SCALE < ARRLEN; i += 1) {
            a.lazySet((i * SCALE), -123);
            b.lazySet((i * SCALE), -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_314().test_2ci_scl(a, b);
    }
}
