import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_13474 {

    static int aParam1 = 992;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = 9;

    static int old = 0;

    static int ARRLEN = 97;

    static int SCALE = 2;

    int test_vi_scl(AtomicIntegerArray a, int b, int old) {
        for (int i = 0; i * SCALE < ARRLEN; i += 1) {
            a.set((i * SCALE), b);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13474().test_vi_scl(a, b, old);
    }
}
