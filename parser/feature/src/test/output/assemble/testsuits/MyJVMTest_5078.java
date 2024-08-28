public class MyJVMTest_5078 {

    static byte[] a0 = { 83, 65, -123, -43, -17, 72, 58, -110, 122, 85 };

    static byte[] a1 = { 124, 59, -14, 127, 103, 67, 22, 73, 23, -125 };

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
        new MyJVMTest_5078().test_unrl_addi(a0, a1);
    }
}
