public class MyJVMTest_7530 {

    static short[] a = { 0, 32767, 0, 16155, -14377, 0, 0, 0, -25987, 0 };

    static short[] b = { -9901, 8157, -32768, 32767, 0, 0, 2821, 32767, -24158, 32767 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_cp_unalndst(short[] a, short[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7530().test_cp_unalndst(a, b);
    }
}
