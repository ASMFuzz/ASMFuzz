public class MyJVMTest_14346 {

    static byte[] a = { 45, 22, 109, -16, -8, 15, -99, -75, 56, -126 };

    static byte[] b = { 92, -102, 61, 25, 11, 120, 106, 23, -5, 74 };

    byte[] test_cp_oppos(byte[] a, byte[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14346().test_cp_oppos(a, b);
    }
}
