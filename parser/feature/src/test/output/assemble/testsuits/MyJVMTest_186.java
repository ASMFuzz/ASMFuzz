public class MyJVMTest_186 {

    static short[] a = { 32767, 0, 0, 0, 0, -32768, 0, 28184, -27258, 0 };

    static short[] b = { -2082, 0, 32767, 6948, 32767, -30863, -2426, 32767, 14241, -32768 };

    static int SCALE = 2;

    short[] test_cp_scl(short[] a, short[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b[i * SCALE];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_186().test_cp_scl(a, b);
    }
}
