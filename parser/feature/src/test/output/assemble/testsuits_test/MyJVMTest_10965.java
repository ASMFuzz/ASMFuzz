import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_10965 {

    static int aParam1 = 896;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 891;

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
        new MyJVMTest_10965().test_2ci(a, b);
    }
}
