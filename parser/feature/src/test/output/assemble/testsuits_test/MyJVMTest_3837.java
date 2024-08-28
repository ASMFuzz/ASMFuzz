public class MyJVMTest_3837 {

    static byte[] a = { 120, -22, -29, 75, 112, 90, 13, 33, 94, -17 };

    static int OFFSET = 3;

    byte[] test_ci_off(byte[] a) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3837().test_ci_off(a);
    }
}
