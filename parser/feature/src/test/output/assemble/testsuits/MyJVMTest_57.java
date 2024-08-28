public class MyJVMTest_57 {

    static byte[] a0 = { -100, -14, -95, -58, 63, -117, 38, 26, 51, -111 };

    byte[] test_unrl_init(byte[] a0) {
        int i = 0;
        for (; i < a0.length - 4; i += 4) {
            a0[i + 0] = 0;
            a0[i + 1] = 1;
            a0[i + 2] = 2;
            a0[i + 3] = 3;
        }
        for (; i < a0.length; i++) {
            a0[i] = (byte) (i & 3);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_57().test_unrl_init(a0);
    }
}
