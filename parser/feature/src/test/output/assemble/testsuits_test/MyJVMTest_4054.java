public class MyJVMTest_4054 {

    static byte[] a = { 118, 89, -71, -63, -41, -38, -82, 49, 116, -90 };

    static byte[] b = { 88, -14, 61, -67, -50, -94, 103, -76, -78, 65 };

    byte[] test_2ci(byte[] a, byte[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4054().test_2ci(a, b);
    }
}
