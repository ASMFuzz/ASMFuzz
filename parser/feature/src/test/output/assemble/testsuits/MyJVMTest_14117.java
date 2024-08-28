import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_14117 {

    static int[] aParam1 = { -2099541831, 3, -417936453, 0, 0, 7, 1, 5, 9, 1159526897 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 0, 8, 1729209296, 3, 0, 925769771, 0, 4, 1165362747, 7 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    AtomicIntegerArray test_cp_unalndst(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i < ARRLEN - UNALIGN_OFF; i += 1) {
            a.set((i + UNALIGN_OFF), b.get(i));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14117().test_cp_unalndst(a, b);
    }
}
