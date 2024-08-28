import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_4712 {

    static int aParam1 = 266;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int ARRLEN = 97;

    AtomicIntegerArray test_ci(AtomicIntegerArray a) {
        for (int i = 0; i < ARRLEN; i += 1) {
            a.lazySet(i, -123);
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4712().test_ci(a);
    }
}
