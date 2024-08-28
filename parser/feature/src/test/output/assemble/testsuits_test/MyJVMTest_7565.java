public class MyJVMTest_7565 {

    static short[] a = { 0, 0, 513, 32767, -30159, -32768, -589, -8982, 0, -32768 };

    static short[] b = { 0, 5344, 32767, 0, 32767, 32767, -32768, 0, -3480, 0 };

    static short c = 32767;

    static short d = 0;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_2vi_unaln(short[] a, short[] b, short c, short d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7565().test_2vi_unaln(a, b, c, d);
    }
}
