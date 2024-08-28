import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_1613 {

    static int[] aParam1 = { 6, 5, 0, 0, 5, 7, 0, -1771810253, 136239404, 2 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, -1750139564, 8, 8, 3, 1769156497, 0, 7, 334603926, 9 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    AtomicIntegerArray test_cp(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN; i += 1) {
            a.lazySet(i, b.get(i));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1613().test_cp(a, b);
    }
}
