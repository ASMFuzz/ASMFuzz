public class MyJVMTest_3007 {

    static byte[] a0 = { 92, -124, 126, -114, -44, -115, 122, -31, -20, 127 };

    static byte[] a1 = { -1, -91, 120, -63, -93, -13, -81, -14, -99, -58 };

    byte[] test_lsai(byte[] a0, byte[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (byte) (a1[i] << (i & 3));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3007().test_lsai(a0, a1);
    }
}
