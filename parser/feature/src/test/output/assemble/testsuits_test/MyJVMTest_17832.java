public class MyJVMTest_17832 {

    static byte[] a0 = { 70, 123, 49, 39, -94, 63, 90, 1, 25, 47 };

    static byte[] a1 = { -36, -82, 17, -120, 57, -48, 17, -31, 62, 13 };

    byte[] test_addi(byte[] a0, byte[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (byte) (a1[i] + (i & 3));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17832().test_addi(a0, a1);
    }
}
