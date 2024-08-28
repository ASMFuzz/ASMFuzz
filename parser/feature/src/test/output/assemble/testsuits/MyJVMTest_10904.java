public class MyJVMTest_10904 {

    static short[] a = { 32767, -32768, -32768, -32768, 32767, 32767, -2983, -17483, -31591, 0 };

    static int SCALE = 2;

    short[] test_ci_scl(short[] a) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10904().test_ci_scl(a);
    }
}
