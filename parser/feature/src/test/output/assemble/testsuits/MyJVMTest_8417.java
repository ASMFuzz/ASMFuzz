import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_8417 {

    static int[] aParam1 = { 0, 3, 7, 1971886484, 0, 217144216, 8, 938474457, -2078336931, 2 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int ARRLEN = 97;

    AtomicIntegerArray test_ci(AtomicIntegerArray a) {
        for (int i = 0; i < ARRLEN; i += 1) {
            a.set(i, -123);
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8417().test_ci(a);
    }
}
