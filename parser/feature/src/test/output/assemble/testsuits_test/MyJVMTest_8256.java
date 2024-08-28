public class MyJVMTest_8256 {

    static byte[] a0 = { -5, 74, 64, -127, -68, 42, 21, 101, -61, 100 };

    static byte[] a1 = { -90, -22, 77, 62, 3, 12, -119, 64, -42, -85 };

    byte[] test_addi(byte[] a0, byte[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (byte) (a1[i] + (i & 3));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8256().test_addi(a0, a1);
    }
}
