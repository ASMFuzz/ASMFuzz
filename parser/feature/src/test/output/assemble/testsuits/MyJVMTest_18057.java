import java.util.concurrent.atomic.AtomicIntegerArray;

public class MyJVMTest_18057 {

    static int[] aParam1 = { 0, 1449661502, 0, 2, 0, 9, 0, 575965613, 8, 0 };

    static AtomicIntegerArray a = new AtomicIntegerArray(aParam1);

    static int[] bParam1 = { 2143999953, 663547376, -234017184, -1123466137, 3, 3, -246085920, -583408404, 9, 9 };

    static AtomicIntegerArray b = new AtomicIntegerArray(bParam1);

    static int ARRLEN = 97;

    static int SCALE = 2;

    AtomicIntegerArray test_cp_scl(AtomicIntegerArray a, AtomicIntegerArray b) {
        for (int i = 0; i * SCALE < ARRLEN; i += 1) {
            a.set((i * SCALE), b.get(i * SCALE));
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18057().test_cp_scl(a, b);
    }
}
