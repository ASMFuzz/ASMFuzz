public class MyJVMTest_13179 {

    static byte[] a = { 3, 86, 85, -100, -107, 89, 17, -37, 17, -61 };

    static int OFFSET = 3;

    byte[] test_ci_off(byte[] a) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13179().test_ci_off(a);
    }
}
