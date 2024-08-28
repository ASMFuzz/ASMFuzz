public class MyJVMTest_6629 {

    static byte[] ba = { -25, 39, -5, -109, 6, -33, -19, 124, -120, -111 };

    long loadB2L_mask8(byte[] ba) {
        return ba[0] & 0x55;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6629().loadB2L_mask8(ba));
    }
}
