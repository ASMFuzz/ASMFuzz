public class MyJVMTest_15540 {

    static short[] a = { -32768, -32768, 0, 32767, 0, 0, 0, -32768, 0, 0 };

    static int[] b = { 2, 0, 9, 6, 0, 132142034, 2, 2, -1913310987, -254297669 };

    static short c = -32768;

    static int d = 8;

    static int ALIGN_OFF = 8;

    short[] test_vi_aln(short[] a, int[] b, short c, int d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15540().test_vi_aln(a, b, c, d);
    }
}
