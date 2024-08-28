public class MyJVMTest_11796 {

    static byte[] a = { 76, -6, -32, -78, -34, 119, 78, 59, 68, -31 };

    static int[] b = { 641460712, -1728685865, 1, 1, 8, 4, 0, 4, 0, 0 };

    byte[] test_ci(byte[] a, int[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11796().test_ci(a, b);
    }
}
