public class MyJVMTest_6082 {

    static short[] a = { -32768, 28849, -32768, -27878, 31009, 32767, 0, -20734, 32767, -32768 };

    static int[] b = { 1, 0, 9, 9, 6, 7, 9, 4, 20301956, 1064250584 };

    static short c = 0;

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
        new MyJVMTest_6082().test_vi_aln(a, b, c, d);
    }
}
