public class MyJVMTest_2793 {

    static byte[] a0 = { 89, 13, 73, 27, -23, -47, -104, -66, -45, -21 };

    byte[] test_init(byte[] a0) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (byte) (i & 3);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2793().test_init(a0);
    }
}
