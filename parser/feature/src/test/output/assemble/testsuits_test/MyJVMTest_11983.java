public class MyJVMTest_11983 {

    static short[] a = { 32767, 32767, 20587, 32767, 32767, 32767, -32768, -32768, 32767, 32767 };

    static short[] b = { 0, 32767, -2650, -32768, 21979, 0, -28341, -32768, 32767, 0 };

    static int SCALE = 2;

    short[] test_2ci_scl(short[] a, short[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = -123;
            b[i * SCALE] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11983().test_2ci_scl(a, b);
    }
}
