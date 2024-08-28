import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_15574 {

    static int[] aParam1 = { 0, -1837353611, 1880833167, 2, 73254371, 0, 0, 3, 1, 6 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int b = 1897283031;

    static int old = 0;

    static int ARRLEN = 97;

    int test_vi(AtomicIntegerArray a, int b, int old) {
        for (int i = 0; i < ARRLEN; i += 1) {
            a.lazySet(i, b);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15574().test_vi(a, b, old);
    }
}
