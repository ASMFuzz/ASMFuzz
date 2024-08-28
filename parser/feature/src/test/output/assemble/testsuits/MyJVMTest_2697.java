public class MyJVMTest_2697 {

    static short[] a = { 0, 26383, -32768, 0, 28137, 17091, 32767, -32768, 32767, 0 };

    static short[] b = { -32768, 32767, -32768, 32767, -32768, 32767, 32499, 32767, 32767, 32767 };

    static int SCALE = 2;

    short[] test_2ci_scl(short[] a, short[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = -123;
            b[i * SCALE] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2697().test_2ci_scl(a, b);
    }
}
