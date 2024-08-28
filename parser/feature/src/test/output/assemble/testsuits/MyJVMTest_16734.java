public class MyJVMTest_16734 {

    static byte[] a0 = { -81, -37, -75, -75, 90, -29, 53, 61, -67, 84 };

    static byte[] a1 = { -13, -109, -104, 100, -89, 111, -35, 36, 94, -82 };

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
        new MyJVMTest_16734().test_unrl_lsai(a0, a1);
    }
}
