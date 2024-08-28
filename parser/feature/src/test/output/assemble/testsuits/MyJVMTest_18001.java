import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_18001 {

    static int aParam1 = 303;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int ARRLEN = 97;

    AtomicIntegerArray test_ci(AtomicIntegerArray a) {
        for (int i = 0; i < ARRLEN; i += 1) {
            a.set(i, -123);
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18001().test_ci(a);
    }
}
