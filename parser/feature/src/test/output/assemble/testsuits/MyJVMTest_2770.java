public class MyJVMTest_2770 {

    static short[] a = { 32767, -32768, -23664, -32768, -32768, -32768, -12431, -15405, -17067, -32768 };

    static short[] b = { -32768, -32768, 32767, 0, 32767, -32768, 0, 32767, -32768, 0 };

    static int[] c = { 3, 0, -40965523, 0, 8, 6, 0, 0, 0, 6 };

    static int[] d = { 0, 0, 7, 5, 7, 0, 0, 7, 0, 8 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_cp_unalndst(short[] a, short[] b, int[] c, int[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
            c[i + UNALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2770().test_cp_unalndst(a, b, c, d);
    }
}
