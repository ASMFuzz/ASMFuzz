public class MyJVMTest_1682 {

    static short[] a = { -20274, 2658, 0, 1461, -1560, 0, 0, -32768, 0, 32767 };

    static int SCALE = 2;

    short[] test_ci_scl(short[] a) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1682().test_ci_scl(a);
    }
}
