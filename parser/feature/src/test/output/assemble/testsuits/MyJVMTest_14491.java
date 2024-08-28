public class MyJVMTest_14491 {

    static byte[] a0 = { 111, 40, 33, -17, -61, 115, 95, 24, -14, 88 };

    static byte[] a1 = { -58, -81, -31, -115, -50, 98, -98, 104, 51, 70 };

    byte[] test_unrl_addi(byte[] a0, byte[] a1) {
        int i = 0;
        for (; i < a0.length - 4; i += 4) {
            a0[i + 0] = (byte) (a1[i + 0] + 0);
            a0[i + 1] = (byte) (a1[i + 1] + 1);
            a0[i + 2] = (byte) (a1[i + 2] + 2);
            a0[i + 3] = (byte) (a1[i + 3] + 3);
        }
        for (; i < a0.length; i++) {
            a0[i] = (byte) (a1[i] + (i & 3));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14491().test_unrl_addi(a0, a1);
    }
}
