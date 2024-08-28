public class MyJVMTest_2194 {

    static short[] a = { -32768, 32767, 32767, 0, 0, -32768, 32767, 32767, 9987, 32767 };

    static short[] b = { -32768, 0, 22612, -32768, -32768, 22186, 32767, -11493, -5747, -32768 };

    static int ALIGN_OFF = 8;

    short[] test_cp_alndst(short[] a, short[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2194().test_cp_alndst(a, b);
    }
}
