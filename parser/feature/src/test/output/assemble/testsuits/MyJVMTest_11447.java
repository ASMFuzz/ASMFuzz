public class MyJVMTest_11447 {

    static short[] a = { 0, 0, -32768, 32767, 32767, 32767, 32767, -32768, -21582, 26116 };

    static short[] b = { -32629, 32767, 24412, -32768, 17935, -6371, -32768, -32768, -16977, 0 };

    static int ALIGN_OFF = 8;

    short[] test_cp_alndst(short[] a, short[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11447().test_cp_alndst(a, b);
    }
}
