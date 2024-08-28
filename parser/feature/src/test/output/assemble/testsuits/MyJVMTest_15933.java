public class MyJVMTest_15933 {

    static byte[] a = { 66, 54, -124, 46, 22, -72, -78, 2, 119, -111 };

    static short[] b = { 32767, -3087, 0, -8508, 32767, 15104, 7882, 26950, 0, 31591 };

    byte[] test_ci_oppos(byte[] a, short[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15933().test_ci_oppos(a, b);
    }
}
