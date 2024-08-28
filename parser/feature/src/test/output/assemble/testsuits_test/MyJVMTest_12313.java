public class MyJVMTest_12313 {

    static byte[] a0 = { -63, -46, -62, -30, 22, 105, 66, 94, 85, 55 };

    static byte[] a1 = { 17, 40, 8, -114, -30, -29, 109, -35, -57, -108 };

    byte[] test_lsai(byte[] a0, byte[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (byte) (a1[i] << (i & 3));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12313().test_lsai(a0, a1);
    }
}
