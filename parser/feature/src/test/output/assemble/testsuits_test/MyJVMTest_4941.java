public class MyJVMTest_4941 {

    static byte[] a = { 27, 14, 35, 59, -102, 73, -74, -61, 100, -20 };

    static byte[] b = { 78, -47, -54, 107, -33, 59, -72, 115, 3, 8 };

    byte[] test_cp_oppos(byte[] a, byte[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4941().test_cp_oppos(a, b);
    }
}
