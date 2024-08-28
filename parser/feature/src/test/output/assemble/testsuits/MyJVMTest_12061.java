public class MyJVMTest_12061 {

    static short[] a = { 32767, 0, -32768, 32767, -32768, 0, 23830, -32768, 32767, 0 };

    static short[] b = { 32767, -32768, -23121, 0, -32768, 32767, 0, -22811, -677, 32767 };

    static int[] c = { 0, 7, 2, 5, 9, 9, 1, 1117659399, -1732663214, 5 };

    static int[] d = { 8, -1382655793, -564777635, 6, 0, -1059762835, 1172673781, 8, 0, 3 };

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
        new MyJVMTest_12061().test_cp_unalndst(a, b, c, d);
    }
}
