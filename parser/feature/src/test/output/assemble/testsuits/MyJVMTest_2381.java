public class MyJVMTest_2381 {

    static short[] a = { 32767, -23867, 0, 32767, -32768, 0, -32768, -32768, -32768, -32768 };

    static int[] b = { 0, 0, 0, 5, 0, 0, 8, 7, 8, 0 };

    static short c = -32768;

    static int d = -264761210;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_vi_unaln(short[] a, int[] b, short c, int d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2381().test_vi_unaln(a, b, c, d);
    }
}
