import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_3030 {

    static int[] aParam1 = { 0, 1237115512, 111487546, 2066218066, 0, 0, 0, 884463663, 2, 5 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int bParam1 = 699;

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    int test_cp_oppos(AtomicIntegerArray a, AtomicIntegerArray b) {
        int limit = ARRLEN - 1;
        for (int i = 0; i < ARRLEN; i += 1) {
            a.lazySet(i, b.get(limit - i));
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3030().test_cp_oppos(a, b);
    }
}
