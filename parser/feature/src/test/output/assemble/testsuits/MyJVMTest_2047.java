public class MyJVMTest_2047 {

    static byte[] ba = { -38, -127, -12, -109, -30, -55, 99, 62, 49, 16 };

    long _loadB2L_mask8(byte[] ba) {
        return ba[0] & 0x55;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2047()._loadB2L_mask8(ba));
    }
}
