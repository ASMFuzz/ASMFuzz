public class MyJVMTest_2525 {

    static byte[] a = { 69, 101, 80, 123, 122, -31, 72, -114, 93, 44 };

    static int[] b = { 0, 0, 9, 3, 8, 8, 2119804720, 0, 0, 6 };

    byte[] test_ci(byte[] a, int[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2525().test_ci(a, b);
    }
}
