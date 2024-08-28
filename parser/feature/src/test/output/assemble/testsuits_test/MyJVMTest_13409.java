public class MyJVMTest_13409 {

    static byte[] a = { 108, -116, 54, -44, 67, -35, -3, -65, 105, 62 };

    static byte[] b = { 78, -54, -19, 67, 61, 22, 17, -46, 103, 123 };

    byte[] test_2ci(byte[] a, byte[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13409().test_2ci(a, b);
    }
}
