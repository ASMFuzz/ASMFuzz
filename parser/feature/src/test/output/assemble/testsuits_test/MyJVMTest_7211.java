public class MyJVMTest_7211 {

    static byte[] a0 = { 56, 85, 68, -103, 0, -33, 31, -126, -34, -76 };

    static byte[] a1 = { 22, 89, -51, 97, 52, -116, -87, -109, -97, 94 };

    byte[] test_unrl_lsai(byte[] a0, byte[] a1) {
        int i = 0;
        for (; i < a0.length - 4; i += 4) {
            a0[i + 0] = (byte) (a1[i + 0] << 0);
            a0[i + 1] = (byte) (a1[i + 1] << 1);
            a0[i + 2] = (byte) (a1[i + 2] << 2);
            a0[i + 3] = (byte) (a1[i + 3] << 3);
        }
        for (; i < a0.length; i++) {
            a0[i] = (byte) (a1[i] << (i & 3));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7211().test_unrl_lsai(a0, a1);
    }
}
