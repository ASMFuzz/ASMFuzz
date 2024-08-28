public class MyJVMTest_16125 {

    static byte[] ba = { -38, 124, 30, -68, -6, -98, -72, 69, -85, -31 };

    long loadB2L_mask8(byte[] ba) {
        return ba[0] & 0x55;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16125().loadB2L_mask8(ba));
    }
}
