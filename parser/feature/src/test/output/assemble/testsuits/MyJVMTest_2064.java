import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_2064 {

    static int aParam1 = 623;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, -1805650618, 8, 4, 1816463802, -915599351, 0, 0, 8, -1635501349 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int OFFSET = 3;

    AtomicIntegerArray test_2ci_off(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - OFFSET; i += 1) {
            a.set((i + OFFSET), -123);
            b.set((i + OFFSET), -103);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2064().test_2ci_off(a, b);
    }
}
