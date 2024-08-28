import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_11430 {

    static int[] aParam1 = { 2, -411292213, 0, 759969694, 7, 2, 0, 0, 0, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { -730011563, 0, 5, 9, 2114057866, 1774950485, 0, -908052235, 2, 3 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    AtomicIntegerArray test_cp_neg(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = ARRLEN - 1; i >= 0; i -= 1) {
            a.lazySet(i, b.get(i));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11430().test_cp_neg(a, b);
    }
}
