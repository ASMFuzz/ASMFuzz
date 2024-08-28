public class MyJVMTest_6397 {

    static short[] a = { -10251, -32768, -32768, 32767, 0, -17047, 14875, 32767, 32767, -32768 };

    static short[] b = { -8454, -32768, 0, -32768, 32767, 3759, -32768, -30122, -32768, 0 };

    static int[] c = { 9, 7, 0, 9, 0, 2, 1559711718, 5, 147466024, 0 };

    static int[] d = { 8, 0, 1, 153049845, 562816861, 6, 5, 0, 6, 0 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_cp_unalnsrc(short[] a, short[] b, int[] c, int[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6397().test_cp_unalnsrc(a, b, c, d);
    }
}
