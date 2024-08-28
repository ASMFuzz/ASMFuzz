import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_3662 {

    static int aParam1 = 757;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, -463156939, -1224174516, 0, 0, 0, 9, 1, 1, 1 };

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
        new MyJVMTest_3662().test_2ci(a, b);
    }
}
