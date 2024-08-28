import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_1742 {

    static int aParam1 = 172;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { -1003594567, 1, 0, 580609795, 2, -1490648076, 3, 0, 0, -1012907818 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    AtomicIntegerArray test_2ci(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN; i += 1) {
            a.set(i, -123);
            b.set(i, -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1742().test_2ci(a, b);
    }
}
