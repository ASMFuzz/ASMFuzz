public class MyJVMTest_12087 {

    static byte[] a0 = { -41, 65, -109, 47, 121, -88, -37, 73, 0, -66 };

    byte[] test_init(byte[] a0) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (byte) (i & 3);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12087().test_init(a0);
    }
}
