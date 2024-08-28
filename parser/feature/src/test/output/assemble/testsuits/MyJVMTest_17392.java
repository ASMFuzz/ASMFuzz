import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_17392 {

    static int aParam1 = 669;

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { -1620514327, -609041220, 5, 2, 1497528251, 0, 0, -555601757, 1103564067, 0 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    AtomicIntegerArray test_cp_alnsrc(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - ALIGN_OFF; i += 1) {
            a.lazySet(i, b.get(i + ALIGN_OFF));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17392().test_cp_alnsrc(a, b);
    }
}
