public class MyJVMTest_7989 {

    static short[] a = { -32768, -32768, -32768, -32768, 32767, 18380, 0, -32768, 0, 0 };

    static short[] b = { 32767, 0, 32767, 0, -32768, -15675, -32768, -27758, -22545, -32768 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_2ci_unaln(short[] a, short[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7989().test_2ci_unaln(a, b);
    }
}
